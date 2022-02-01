package io.flutter.view;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.c.f;
import io.flutter.c.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends AccessibilityNodeProvider
{
  private static int JcI = 267386881;
  public a.e IXU;
  private final io.flutter.embedding.engine.c.a IYh;
  final View JcJ;
  public final b JcK;
  private final f JcL;
  final Map<Integer, f> JcM;
  private final Map<Integer, c> JcN;
  public f JcO;
  public Integer JcP;
  public Integer JcQ;
  private int JcR;
  public f JcS;
  public f JcT;
  final List<Integer> JcU;
  int JcV;
  Integer JcW;
  private final io.flutter.embedding.engine.c.a.a JcX;
  private final AccessibilityManager.AccessibilityStateChangeListener JcY;
  @TargetApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener JcZ;
  private final ContentObserver Jda;
  private final ContentResolver aCR;
  public final AccessibilityManager kI;
  
  public a(View paramView, io.flutter.embedding.engine.c.a parama, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, f paramf)
  {
    AppMethodBeat.i(9750);
    this.JcM = new HashMap();
    this.JcN = new HashMap();
    this.JcR = 0;
    this.JcU = new ArrayList();
    this.JcV = 0;
    this.JcW = Integer.valueOf(0);
    this.JcX = new io.flutter.embedding.engine.c.a.a()
    {
      public final void aPL(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        a.b(a.this).announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public final void aPM(String paramAnonymousString)
      {
        AppMethodBeat.i(9691);
        AccessibilityEvent localAccessibilityEvent = a.c(a.this);
        localAccessibilityEvent.getText().add(paramAnonymousString);
        a.a(a.this, localAccessibilityEvent);
        AppMethodBeat.o(9691);
      }
      
      public final void adB(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        a.a(a.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public final void adC(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        a.a(a.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public final void updateCustomAccessibilityActions(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9692);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        a locala = a.this;
        if (paramAnonymousByteBuffer.hasRemaining())
        {
          a.c localc = locala.adJ(paramAnonymousByteBuffer.getInt());
          localc.JdE = paramAnonymousByteBuffer.getInt();
          int i = paramAnonymousByteBuffer.getInt();
          if (i == -1)
          {
            str = null;
            label60:
            localc.label = str;
            i = paramAnonymousByteBuffer.getInt();
            if (i != -1) {
              break label98;
            }
          }
          label98:
          for (String str = null;; str = paramAnonymousArrayOfString[i])
          {
            localc.hint = str;
            break;
            str = paramAnonymousArrayOfString[i];
            break label60;
          }
        }
        AppMethodBeat.o(9692);
      }
      
      public final void updateSemantics(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9693);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        a locala = a.this;
        Object localObject1 = new ArrayList();
        while (paramAnonymousByteBuffer.hasRemaining())
        {
          localObject2 = locala.adI(paramAnonymousByteBuffer.getInt());
          ((a.f)localObject2).a(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
          if (!((a.f)localObject2).a(a.d.JdS))
          {
            if (((a.f)localObject2).a(a.d.JdK)) {
              locala.JcS = ((a.f)localObject2);
            }
            if (((a.f)localObject2).Jem) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        Object localObject2 = new HashSet();
        paramAnonymousByteBuffer = locala.fvl();
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousByteBuffer != null)
        {
          paramAnonymousArrayOfString = new float[16];
          Matrix.setIdentityM(paramAnonymousArrayOfString, 0);
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject3 = locala.JcJ.getRootWindowInsets();
            if (localObject3 != null)
            {
              if (!locala.JcW.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
              {
                paramAnonymousByteBuffer.JeE = true;
                paramAnonymousByteBuffer.JeC = true;
              }
              locala.JcW = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
              Matrix.translateM(paramAnonymousArrayOfString, 0, locala.JcW.intValue(), 0.0F, 0.0F);
            }
          }
          paramAnonymousByteBuffer.a(paramAnonymousArrayOfString, (Set)localObject2, false);
          paramAnonymousByteBuffer.iv(localArrayList);
        }
        paramAnonymousByteBuffer = null;
        Object localObject3 = localArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramAnonymousArrayOfString = (a.f)((Iterator)localObject3).next();
          if (locala.JcU.contains(Integer.valueOf(paramAnonymousArrayOfString.id))) {
            break label1490;
          }
          paramAnonymousByteBuffer = paramAnonymousArrayOfString;
        }
        label653:
        label810:
        label959:
        label973:
        label1487:
        label1490:
        for (;;)
        {
          break;
          paramAnonymousArrayOfString = paramAnonymousByteBuffer;
          if (paramAnonymousByteBuffer == null)
          {
            paramAnonymousArrayOfString = paramAnonymousByteBuffer;
            if (localArrayList.size() > 0) {
              paramAnonymousArrayOfString = (a.f)localArrayList.get(localArrayList.size() - 1);
            }
          }
          if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.id != locala.JcV))
          {
            locala.JcV = paramAnonymousArrayOfString.id;
            paramAnonymousByteBuffer = locala.kG(paramAnonymousArrayOfString.id, 32);
            paramAnonymousArrayOfString = paramAnonymousArrayOfString.fvn();
            paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
          }
          locala.JcU.clear();
          paramAnonymousByteBuffer = localArrayList.iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)paramAnonymousByteBuffer.next();
            locala.JcU.add(Integer.valueOf(paramAnonymousArrayOfString.id));
          }
          paramAnonymousByteBuffer = locala.JcM.entrySet().iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)((Map.Entry)paramAnonymousByteBuffer.next()).getValue();
            if (!((Set)localObject2).contains(paramAnonymousArrayOfString))
            {
              paramAnonymousArrayOfString.Jew = null;
              if (locala.JcO == paramAnonymousArrayOfString)
              {
                locala.kF(locala.JcO.id, 65536);
                locala.JcO = null;
              }
              if (locala.JcS == paramAnonymousArrayOfString) {
                locala.JcS = null;
              }
              if (locala.JcT == paramAnonymousArrayOfString) {
                locala.JcT = null;
              }
              paramAnonymousByteBuffer.remove();
            }
          }
          locala.kF(0, 2048);
          localObject1 = ((ArrayList)localObject1).iterator();
          int i;
          float f3;
          float f2;
          float f1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f)((Iterator)localObject1).next();
            if ((!Float.isNaN(((a.f)localObject2).Jeg)) && (!Float.isNaN(((a.f)localObject2).Jer)) && (((a.f)localObject2).Jer != ((a.f)localObject2).Jeg))
            {
              i = 1;
              if (i == 0) {
                break label979;
              }
              paramAnonymousByteBuffer = locala.kG(((a.f)localObject2).id, 4096);
              f3 = ((a.f)localObject2).Jeg;
              f2 = ((a.f)localObject2).Jeh;
              f1 = f3;
              if (Float.isInfinite(((a.f)localObject2).Jeh))
              {
                float f4 = 100000.0F;
                f2 = f4;
                f1 = f3;
                if (f3 > 70000.0F)
                {
                  f1 = 70000.0F;
                  f2 = f4;
                }
              }
              if (!Float.isInfinite(((a.f)localObject2).Jei)) {
                break label892;
              }
              f3 = f2 + 100000.0F;
              f2 = f1;
              if (f1 < -70000.0F) {
                f2 = -70000.0F;
              }
              f2 += 100000.0F;
              f1 = f3;
              if ((!((a.f)localObject2).b(a.b.Jdm)) && (!((a.f)localObject2).b(a.b.Jdn))) {
                break label921;
              }
              paramAnonymousByteBuffer.setScrollY((int)f2);
              paramAnonymousByteBuffer.setMaxScrollY((int)f1);
              if (((a.f)localObject2).Jee <= 0) {
                break label973;
              }
              paramAnonymousByteBuffer.setItemCount(((a.f)localObject2).Jee);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).Jef);
              paramAnonymousArrayOfString = ((a.f)localObject2).Jey.iterator();
              i = 0;
              label850:
              if (!paramAnonymousArrayOfString.hasNext()) {
                break label959;
              }
              if (((a.f)paramAnonymousArrayOfString.next()).a(a.d.JdS)) {
                break label1487;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break label850;
            i = 0;
            break label653;
            label892:
            f2 -= ((a.f)localObject2).Jei;
            f3 = f1 - ((a.f)localObject2).Jei;
            f1 = f2;
            f2 = f3;
            break label775;
            if ((!((a.f)localObject2).b(a.b.Jdk)) && (!((a.f)localObject2).b(a.b.Jdl))) {
              break label810;
            }
            paramAnonymousByteBuffer.setScrollX((int)f2);
            paramAnonymousByteBuffer.setMaxScrollX((int)f1);
            break label810;
            paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).Jef + i - 1);
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            label979:
            if (((a.f)localObject2).a(a.d.JdU)) {
              if (((a.f)localObject2).label == null)
              {
                paramAnonymousByteBuffer = "";
                label1002:
                if (((a.f)localObject2).Jev != null) {
                  break label1344;
                }
                paramAnonymousArrayOfString = "";
                label1014:
                if ((!paramAnonymousByteBuffer.equals(paramAnonymousArrayOfString)) || (!((a.f)localObject2).b(a.d.JdU))) {
                  locala.kF(((a.f)localObject2).id, 2048);
                }
                if ((locala.JcO != null) && (locala.JcO.id == ((a.f)localObject2).id) && (!((a.f)localObject2).b(a.d.JdH)) && (((a.f)localObject2).a(a.d.JdH)))
                {
                  paramAnonymousByteBuffer = locala.kG(((a.f)localObject2).id, 4);
                  paramAnonymousByteBuffer.getText().add(((a.f)localObject2).label);
                  locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
                }
                if ((locala.JcS == null) || (locala.JcS.id != ((a.f)localObject2).id) || (!((a.f)localObject2).b(a.d.JdJ)) || (!((a.f)localObject2).a(a.d.JdJ)) || ((locala.JcO != null) && (locala.JcO.id != locala.JcS.id))) {
                  break;
                }
                if (((a.f)localObject2).Jeu == null) {
                  break label1466;
                }
                paramAnonymousByteBuffer = ((a.f)localObject2).Jeu;
                if (((a.f)localObject2).value == null) {
                  break label1473;
                }
              }
            }
            for (paramAnonymousArrayOfString = ((a.f)localObject2).value;; paramAnonymousArrayOfString = "")
            {
              paramAnonymousByteBuffer = locala.W(((a.f)localObject2).id, paramAnonymousByteBuffer, paramAnonymousArrayOfString);
              if (paramAnonymousByteBuffer != null) {
                locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              }
              if ((((a.f)localObject2).Jep == ((a.f)localObject2).Jeb) && (((a.f)localObject2).Jeq == ((a.f)localObject2).Jec)) {
                break;
              }
              paramAnonymousByteBuffer = locala.kG(((a.f)localObject2).id, 8192);
              paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).Jeb);
              paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).Jec);
              paramAnonymousByteBuffer.setItemCount(paramAnonymousArrayOfString.length());
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              break;
              paramAnonymousByteBuffer = ((a.f)localObject2).label;
              break label1002;
              paramAnonymousArrayOfString = ((a.f)localObject2).label;
              break label1014;
              if (!((a.f)localObject2).a(a.d.JdJ)) {
                break label1046;
              }
              if (((((a.f)localObject2).label != null) || (((a.f)localObject2).Jev != null)) && ((((a.f)localObject2).label == null) || (((a.f)localObject2).Jev == null) || (!((a.f)localObject2).label.equals(((a.f)localObject2).Jev)))) {}
              for (i = 1;; i = 0)
              {
                if ((i == 0) || (locala.JcS == null) || (locala.JcS.id != ((a.f)localObject2).id)) {
                  break label1464;
                }
                locala.kF(((a.f)localObject2).id, 2048);
                break;
              }
              break label1046;
              paramAnonymousByteBuffer = "";
              break label1212;
            }
            AppMethodBeat.o(9693);
            return;
          }
        }
      }
    };
    this.JcY = new a.2(this);
    this.Jda = new ContentObserver(new Handler())
    {
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9776);
        onChange(paramAnonymousBoolean, null);
        AppMethodBeat.o(9776);
      }
      
      public final void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
      {
        AppMethodBeat.i(9777);
        int i;
        if (Build.VERSION.SDK_INT < 17)
        {
          paramAnonymousUri = null;
          if ((paramAnonymousUri == null) || (!paramAnonymousUri.equals("0"))) {
            break label87;
          }
          i = 1;
          label31:
          if (i == 0) {
            break label92;
          }
          a.a(a.this, a.i(a.this) | a.a.Jdg.value);
        }
        for (;;)
        {
          a.j(a.this);
          AppMethodBeat.o(9777);
          return;
          paramAnonymousUri = Settings.Global.getString(a.h(a.this), "transition_animation_scale");
          break;
          label87:
          i = 0;
          break label31;
          label92:
          a.a(a.this, a.i(a.this) & (a.a.Jdg.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.JcJ = paramView;
    this.IYh = parama;
    this.kI = paramAccessibilityManager;
    this.aCR = paramContentResolver;
    this.JcL = paramf;
    this.JcY.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.kI.addAccessibilityStateChangeListener(this.JcY);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.JcZ = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (paramAnonymousBoolean) {
            a.a(a.this, a.i(a.this) | a.a.Jde.value);
          }
          for (;;)
          {
            a.j(a.this);
            if (a.f(a.this) != null) {
              a.f(a.this).aR(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            a.k(a.this);
            a.a(a.this, a.i(a.this) & (a.a.Jde.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.JcZ.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.kI.addTouchExplorationStateChangeListener(this.JcZ);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.Jda.onChange(false);
        parama = Settings.Global.getUriFor("transition_animation_scale");
        this.aCR.registerContentObserver(parama, false, this.Jda);
      }
      if (paramf != null) {
        paramf.a(this);
      }
      this.JcK = new b(paramView);
      AppMethodBeat.o(9750);
      return;
      this.JcZ = null;
    }
  }
  
  private boolean a(final f paramf)
  {
    AppMethodBeat.i(9752);
    if ((paramf.Jee > 0) && ((f.a(this.JcO, new c() {})) || (!f.a(this.JcO, new c() {}))))
    {
      AppMethodBeat.o(9752);
      return true;
    }
    AppMethodBeat.o(9752);
    return false;
  }
  
  @TargetApi(18)
  private boolean a(f paramf, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(9755);
    int i = paramBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    boolean bool = paramBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    switch (i)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(9755);
        return false;
        if ((paramBoolean) && (paramf.a(b.Jdr)))
        {
          this.IYh.dispatchSemanticsAction(paramInt, b.Jdr, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!paramf.a(b.Jds)));
      this.IYh.dispatchSemanticsAction(paramInt, b.Jds, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (paramf.a(b.JdB)))
      {
        this.IYh.dispatchSemanticsAction(paramInt, b.JdB, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!paramf.a(b.JdC)));
    this.IYh.dispatchSemanticsAction(paramInt, b.JdC, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.JcM.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    f localf = fvl().r(new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localf != this.JcT)
    {
      if (localf != null) {
        kF(localf.id, 128);
      }
      if (this.JcT != null) {
        kF(this.JcT.id, 256);
      }
      this.JcT = localf;
    }
    AppMethodBeat.o(9762);
  }
  
  private void fvm()
  {
    AppMethodBeat.i(9761);
    if (this.JcT != null)
    {
      kF(this.JcT.id, 256);
      this.JcT = null;
    }
    AppMethodBeat.o(9761);
  }
  
  final AccessibilityEvent W(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = kG(paramInt, 16);
    localAccessibilityEvent.setBeforeText(paramString1);
    localAccessibilityEvent.getText().add(paramString2);
    paramInt = 0;
    while ((paramInt < paramString1.length()) && (paramInt < paramString2.length()) && (paramString1.charAt(paramInt) == paramString2.charAt(paramInt))) {
      paramInt += 1;
    }
    if ((paramInt >= paramString1.length()) && (paramInt >= paramString2.length()))
    {
      AppMethodBeat.o(9763);
      return null;
    }
    localAccessibilityEvent.setFromIndex(paramInt);
    int j = paramString1.length() - 1;
    int i = paramString2.length() - 1;
    while ((j >= paramInt) && (i >= paramInt) && (paramString1.charAt(j) == paramString2.charAt(i)))
    {
      j -= 1;
      i -= 1;
    }
    localAccessibilityEvent.setRemovedCount(j - paramInt + 1);
    localAccessibilityEvent.setAddedCount(i - paramInt + 1);
    AppMethodBeat.o(9763);
    return localAccessibilityEvent;
  }
  
  final f adI(int paramInt)
  {
    AppMethodBeat.i(9758);
    f localf2 = (f)this.JcM.get(Integer.valueOf(paramInt));
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f(this);
      localf1.id = paramInt;
      this.JcM.put(Integer.valueOf(paramInt), localf1);
    }
    AppMethodBeat.o(9758);
    return localf1;
  }
  
  final c adJ(int paramInt)
  {
    AppMethodBeat.i(9759);
    c localc2 = (c)this.JcN.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      localc1.id = paramInt;
      localc1.resourceId = (JcI + paramInt);
      this.JcN.put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(9759);
    return localc1;
  }
  
  public final boolean an(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.kI.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    f localf = fvl().r(new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if (localf.Jed != -1)
    {
      boolean bool = this.JcK.b(localf.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      am(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      fvm();
    }
    new StringBuilder("unexpected accessibility hover event: ").append(paramMotionEvent);
    AppMethodBeat.o(9760);
    return false;
  }
  
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9753);
    Object localObject3;
    if (paramInt >= 65536)
    {
      localObject1 = this.JcK;
      localObject2 = (b.b)((b)localObject1).JeM.get(paramInt);
      if (localObject2 == null)
      {
        AppMethodBeat.o(9753);
        return null;
      }
      if (!((b)localObject1).JeO.containsKey(((b.b)localObject2).view))
      {
        AppMethodBeat.o(9753);
        return null;
      }
      if (((b.b)localObject2).view.getAccessibilityNodeProvider() == null)
      {
        AppMethodBeat.o(9753);
        return null;
      }
      localObject3 = ((b.b)localObject2).view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(((b.b)localObject2).id);
      if (localObject3 == null)
      {
        AppMethodBeat.o(9753);
        return null;
      }
      localObject1 = ((b)localObject1).a((AccessibilityNodeInfo)localObject3, paramInt, ((b.b)localObject2).view);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.JcJ);
      this.JcJ.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.JcM.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.JcJ, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject1 = (f)this.JcM.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject4;
    Object localObject5;
    if (((f)localObject1).Jed != -1)
    {
      localObject2 = this.JcL.n(Integer.valueOf(((f)localObject1).Jed));
      localObject3 = ((f)localObject1).JeG;
      localObject4 = this.JcK;
      paramInt = ((f)localObject1).id;
      localObject1 = ((View)localObject2).createAccessibilityNodeInfo();
      localObject5 = ((b)localObject4).JeL.b((AccessibilityNodeInfo)localObject1);
      if (localObject5 == null)
      {
        AppMethodBeat.o(9753);
        return null;
      }
      ((b)localObject4).JeO.put(localObject2, localObject3);
      ((b)localObject4).B((View)localObject2, (int)(((Long)localObject5).longValue() >> 32), paramInt);
      localObject1 = ((b)localObject4).a((AccessibilityNodeInfo)localObject1, paramInt, (View)localObject2);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject2 = AccessibilityNodeInfo.obtain(this.JcJ, paramInt);
    if (Build.VERSION.SDK_INT >= 18) {
      ((AccessibilityNodeInfo)localObject2).setViewIdResourceName("");
    }
    ((AccessibilityNodeInfo)localObject2).setPackageName(this.JcJ.getContext().getPackageName());
    ((AccessibilityNodeInfo)localObject2).setClassName("android.view.View");
    ((AccessibilityNodeInfo)localObject2).setSource(this.JcJ, paramInt);
    boolean bool1;
    if ((!((f)localObject1).a(d.JdQ)) && (((((b.Jdl.value | b.Jdk.value | b.Jdm.value | b.Jdn.value) ^ 0xFFFFFFFF) & ((f)localObject1).Jea) != 0) || (((f)localObject1).flags != 0) || ((((f)localObject1).label != null) && (!((f)localObject1).label.isEmpty())) || ((((f)localObject1).value != null) && (!((f)localObject1).value.isEmpty())) || ((((f)localObject1).hint != null) && (!((f)localObject1).hint.isEmpty()))))
    {
      bool1 = true;
      ((AccessibilityNodeInfo)localObject2).setFocusable(bool1);
      if (this.JcS != null)
      {
        if (this.JcS.id != paramInt) {
          break label1718;
        }
        bool1 = true;
        label574:
        ((AccessibilityNodeInfo)localObject2).setFocused(bool1);
      }
      if (this.JcO != null)
      {
        if (this.JcO.id != paramInt) {
          break label1724;
        }
        bool1 = true;
        label602:
        ((AccessibilityNodeInfo)localObject2).setAccessibilityFocused(bool1);
      }
      if (((f)localObject1).a(d.JdJ))
      {
        ((AccessibilityNodeInfo)localObject2).setPassword(((f)localObject1).a(d.JdP));
        if (!((f)localObject1).a(d.JdY)) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.EditText");
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          if (((f)localObject1).a(d.JdY)) {
            break label1730;
          }
          bool1 = true;
          label674:
          ((AccessibilityNodeInfo)localObject2).setEditable(bool1);
          if ((((f)localObject1).Jeb != -1) && (((f)localObject1).Jec != -1)) {
            ((AccessibilityNodeInfo)localObject2).setTextSelection(((f)localObject1).Jeb, ((f)localObject1).Jec);
          }
          if ((Build.VERSION.SDK_INT > 18) && (this.JcO != null) && (this.JcO.id == paramInt)) {
            ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
          }
        }
        if (!((f)localObject1).a(b.Jdr)) {
          break label1997;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(256);
      }
    }
    label1024:
    label1084:
    label1354:
    label1997:
    for (int j = 1;; j = 0)
    {
      if (((f)localObject1).a(b.Jds))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = 1;
      }
      int i = j;
      if (((f)localObject1).a(b.JdB))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (((f)localObject1).a(b.JdC))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = i | 0x2;
      }
      ((AccessibilityNodeInfo)localObject2).setMovementGranularities(j);
      if (Build.VERSION.SDK_INT > 18)
      {
        if (((f)localObject1).a(b.Jdt)) {
          ((AccessibilityNodeInfo)localObject2).addAction(131072);
        }
        if (((f)localObject1).a(b.Jdu)) {
          ((AccessibilityNodeInfo)localObject2).addAction(16384);
        }
        if (((f)localObject1).a(b.Jdv)) {
          ((AccessibilityNodeInfo)localObject2).addAction(65536);
        }
        if (((f)localObject1).a(b.Jdw)) {
          ((AccessibilityNodeInfo)localObject2).addAction(32768);
        }
      }
      if (((f)localObject1).a(d.JdI)) {
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Button");
      }
      if (((f)localObject1).a(d.JdT)) {
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ImageView");
      }
      if ((Build.VERSION.SDK_INT > 18) && (((f)localObject1).a(b.JdA)))
      {
        ((AccessibilityNodeInfo)localObject2).setDismissable(true);
        ((AccessibilityNodeInfo)localObject2).addAction(1048576);
      }
      label1122:
      boolean bool4;
      if (((f)localObject1).Jew != null)
      {
        ((AccessibilityNodeInfo)localObject2).setParent(this.JcJ, ((f)localObject1).Jew.id);
        localObject3 = ((f)localObject1).JeG;
        if (((f)localObject1).Jew == null) {
          break label1748;
        }
        localObject4 = ((f)localObject1).Jew.JeG;
        localObject5 = new Rect((Rect)localObject3);
        ((Rect)localObject5).offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent((Rect)localObject5);
        ((AccessibilityNodeInfo)localObject2).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject2).setVisibleToUser(true);
        if ((((f)localObject1).a(d.JdL)) && (!((f)localObject1).a(d.JdM))) {
          break label1758;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setEnabled(bool1);
        if (((f)localObject1).a(b.Jdi))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).JeA == null)) {
            break label1764;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, ((f)localObject1).JeA.hint));
          ((AccessibilityNodeInfo)localObject2).setClickable(true);
        }
        if (((f)localObject1).a(b.Jdj))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).JeB == null)) {
            break label1780;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, ((f)localObject1).JeB.hint));
          ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        }
        label1239:
        if ((((f)localObject1).a(b.Jdk)) || (((f)localObject1).a(b.Jdm)) || (((f)localObject1).a(b.Jdl)) || (((f)localObject1).a(b.Jdn)))
        {
          ((AccessibilityNodeInfo)localObject2).setScrollable(true);
          if (((f)localObject1).a(d.JdX))
          {
            if ((!((f)localObject1).a(b.Jdk)) && (!((f)localObject1).a(b.Jdl))) {
              break label1807;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!a((f)localObject1))) {
              break label1796;
            }
            ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((f)localObject1).Jee, false));
          }
          if ((((f)localObject1).a(b.Jdk)) || (((f)localObject1).a(b.Jdm))) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if ((((f)localObject1).a(b.Jdl)) || (((f)localObject1).a(b.Jdn))) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(b.Jdo)) || (((f)localObject1).a(b.Jdp)))
        {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.SeekBar");
          if (((f)localObject1).a(b.Jdo)) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if (((f)localObject1).a(b.Jdp)) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(d.JdU)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
        }
        boolean bool3 = ((f)localObject1).a(d.JdF);
        bool4 = ((f)localObject1).a(d.JdV);
        if (!bool3)
        {
          bool1 = bool2;
          if (!bool4) {}
        }
        else
        {
          bool1 = true;
        }
        ((AccessibilityNodeInfo)localObject2).setCheckable(bool1);
        if (!bool3) {
          break label1864;
        }
        ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.JdG));
        ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
        if (!((f)localObject1).a(d.JdN)) {
          break label1853;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.RadioButton");
        ((AccessibilityNodeInfo)localObject2).setSelected(((f)localObject1).a(d.JdH));
        if ((this.JcO == null) || (this.JcO.id != paramInt)) {
          break label1916;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).Jez == null)) {
          break label1926;
        }
        localObject3 = ((f)localObject1).Jez.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(((c)localObject4).resourceId, ((c)localObject4).label));
        }
        bool1 = false;
        break;
        bool1 = false;
        break label574;
        bool1 = false;
        break label602;
        bool1 = false;
        break label674;
        ((AccessibilityNodeInfo)localObject2).setParent(this.JcJ);
        break label1024;
        label1748:
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent((Rect)localObject3);
        break label1084;
        label1758:
        bool1 = false;
        break label1122;
        label1764:
        ((AccessibilityNodeInfo)localObject2).addAction(16);
        ((AccessibilityNodeInfo)localObject2).setClickable(true);
        break label1184;
        label1780:
        ((AccessibilityNodeInfo)localObject2).addAction(32);
        ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        break label1239;
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.HorizontalScrollView");
        break label1354;
        if ((Build.VERSION.SDK_INT > 18) && (a((f)localObject1)))
        {
          ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((f)localObject1).Jee, 0, false));
          break label1354;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ScrollView");
        break label1354;
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.CheckBox");
        break label1598;
        if (bool4)
        {
          ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.JdW));
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Switch");
          ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
          break label1598;
        }
        ((AccessibilityNodeInfo)localObject2).setText(f.b((f)localObject1));
        break label1598;
        label1916:
        ((AccessibilityNodeInfo)localObject2).addAction(64);
      }
      localObject1 = ((f)localObject1).Jex.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        if (!((f)localObject3).a(d.JdS)) {
          ((AccessibilityNodeInfo)localObject2).addChild(this.JcJ, ((f)localObject3).id);
        }
      }
      AppMethodBeat.o(9753);
      return localObject2;
    }
  }
  
  public final AccessibilityNodeInfo findFocus(int paramInt)
  {
    AppMethodBeat.i(9756);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(9756);
      return null;
      if (this.JcS != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.JcS.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.JcQ != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.JcQ.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.JcO != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.JcO.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.JcP == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.JcP.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  final f fvl()
  {
    AppMethodBeat.i(9757);
    f localf = (f)this.JcM.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localf;
  }
  
  final void kF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.kI.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    if (paramInt1 == 0)
    {
      this.JcJ.sendAccessibilityEvent(paramInt2);
      AppMethodBeat.o(9764);
      return;
    }
    sendAccessibilityEvent(kG(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  final AccessibilityEvent kG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9766);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setPackageName(this.JcJ.getContext().getPackageName());
    localAccessibilityEvent.setSource(this.JcJ, paramInt1);
    AppMethodBeat.o(9766);
    return localAccessibilityEvent;
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(9754);
    boolean bool;
    Object localObject2;
    if (paramInt1 >= 65536)
    {
      localObject1 = (b.b)this.JcK.JeM.get(paramInt1);
      if (localObject1 == null) {
        bool = false;
      }
      for (;;)
      {
        if ((bool) && (paramInt2 == 128)) {
          this.JcP = null;
        }
        AppMethodBeat.o(9754);
        return bool;
        localObject2 = ((b.b)localObject1).view.getAccessibilityNodeProvider();
        if (localObject2 == null) {
          bool = false;
        } else {
          bool = ((AccessibilityNodeProvider)localObject2).performAction(((b.b)localObject1).id, paramInt2, paramBundle);
        }
      }
    }
    Object localObject1 = (f)this.JcM.get(Integer.valueOf(paramInt1));
    if (localObject1 == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = JcI;
      paramBundle = (c)this.JcN.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.IYh.dispatchSemanticsAction(paramInt1, b.Jdz, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdi);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdj);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (((f)localObject1).a(b.Jdm)) {
        this.IYh.dispatchSemanticsAction(paramInt1, b.Jdm);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (((f)localObject1).a(b.Jdk))
        {
          this.IYh.dispatchSemanticsAction(paramInt1, b.Jdk);
        }
        else
        {
          if (!((f)localObject1).a(b.Jdo)) {
            break;
          }
          ((f)localObject1).value = ((f)localObject1).Jej;
          kF(paramInt1, 4);
          this.IYh.dispatchSemanticsAction(paramInt1, b.Jdo);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (((f)localObject1).a(b.Jdn)) {
        this.IYh.dispatchSemanticsAction(paramInt1, b.Jdn);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (((f)localObject1).a(b.Jdl))
        {
          this.IYh.dispatchSemanticsAction(paramInt1, b.Jdl);
        }
        else
        {
          if (!((f)localObject1).a(b.Jdp)) {
            break;
          }
          ((f)localObject1).value = ((f)localObject1).Jek;
          kF(paramInt1, 4);
          this.IYh.dispatchSemanticsAction(paramInt1, b.Jdp);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 512: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = a((f)localObject1, paramInt1, paramBundle, false);
      AppMethodBeat.o(9754);
      return bool;
    case 256: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = a((f)localObject1, paramInt1, paramBundle, true);
      AppMethodBeat.o(9754);
      return bool;
    case 128: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdy);
      kF(paramInt1, 65536);
      this.JcO = null;
      this.JcP = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdx);
      kF(paramInt1, 32768);
      if (this.JcO == null) {
        this.JcJ.invalidate();
      }
      this.JcO = ((f)localObject1);
      if ((((f)localObject1).a(b.Jdo)) || (((f)localObject1).a(b.Jdp))) {
        kF(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdq);
      AppMethodBeat.o(9754);
      return true;
    case 131072: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      localObject2 = new HashMap();
      paramInt2 = i;
      if (paramBundle != null)
      {
        paramInt2 = i;
        if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT"))
        {
          paramInt2 = i;
          if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 != 0)
      {
        ((Map)localObject2).put("base", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
        ((Map)localObject2).put("extent", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
      }
      for (;;)
      {
        this.IYh.dispatchSemanticsAction(paramInt1, b.Jdt, localObject2);
        AppMethodBeat.o(9754);
        return true;
        ((Map)localObject2).put("base", Integer.valueOf(((f)localObject1).Jec));
        ((Map)localObject2).put("extent", Integer.valueOf(((f)localObject1).Jec));
      }
    case 16384: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdu);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdv);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.Jdw);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.IYh.dispatchSemanticsAction(paramInt1, b.JdA);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(9751);
    if (this.JcL != null) {
      this.JcL.fvg();
    }
    this.IXU = null;
    this.kI.removeAccessibilityStateChangeListener(this.JcY);
    if (Build.VERSION.SDK_INT >= 19) {
      this.kI.removeTouchExplorationStateChangeListener(this.JcZ);
    }
    this.aCR.unregisterContentObserver(this.Jda);
    AppMethodBeat.o(9751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(9767);
    this.JcM.clear();
    if (this.JcO != null) {
      kF(this.JcO.id, 65536);
    }
    this.JcO = null;
    this.JcT = null;
    kF(0, 2048);
    AppMethodBeat.o(9767);
  }
  
  final void sendAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.kI.isEnabled())
    {
      AppMethodBeat.o(9765);
      return;
    }
    this.JcJ.getParent().requestSendAccessibilityEvent(this.JcJ, paramAccessibilityEvent);
    AppMethodBeat.o(9765);
  }
  
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(9783);
      Jdi = new b("TAP", 0, 1);
      Jdj = new b("LONG_PRESS", 1, 2);
      Jdk = new b("SCROLL_LEFT", 2, 4);
      Jdl = new b("SCROLL_RIGHT", 3, 8);
      Jdm = new b("SCROLL_UP", 4, 16);
      Jdn = new b("SCROLL_DOWN", 5, 32);
      Jdo = new b("INCREASE", 6, 64);
      Jdp = new b("DECREASE", 7, 128);
      Jdq = new b("SHOW_ON_SCREEN", 8, 256);
      Jdr = new b("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      Jds = new b("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      Jdt = new b("SET_SELECTION", 11, 2048);
      Jdu = new b("COPY", 12, 4096);
      Jdv = new b("CUT", 13, 8192);
      Jdw = new b("PASTE", 14, 16384);
      Jdx = new b("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      Jdy = new b("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      Jdz = new b("CUSTOM_ACTION", 17, 131072);
      JdA = new b("DISMISS", 18, 262144);
      JdB = new b("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      JdC = new b("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      JdD = new b[] { Jdi, Jdj, Jdk, Jdl, Jdm, Jdn, Jdo, Jdp, Jdq, Jdr, Jds, Jdt, Jdu, Jdv, Jdw, Jdx, Jdy, Jdz, JdA, JdB, JdC };
      AppMethodBeat.o(9783);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class c
  {
    int JdE = -1;
    String hint;
    int id = -1;
    String label;
    int resourceId = -1;
  }
  
  static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(9679);
      JdF = new d("HAS_CHECKED_STATE", 0, 1);
      JdG = new d("IS_CHECKED", 1, 2);
      JdH = new d("IS_SELECTED", 2, 4);
      JdI = new d("IS_BUTTON", 3, 8);
      JdJ = new d("IS_TEXT_FIELD", 4, 16);
      JdK = new d("IS_FOCUSED", 5, 32);
      JdL = new d("HAS_ENABLED_STATE", 6, 64);
      JdM = new d("IS_ENABLED", 7, 128);
      JdN = new d("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      JdO = new d("IS_HEADER", 9, 512);
      JdP = new d("IS_OBSCURED", 10, 1024);
      JdQ = new d("SCOPES_ROUTE", 11, 2048);
      JdR = new d("NAMES_ROUTE", 12, 4096);
      JdS = new d("IS_HIDDEN", 13, 8192);
      JdT = new d("IS_IMAGE", 14, 16384);
      JdU = new d("IS_LIVE_REGION", 15, 32768);
      JdV = new d("HAS_TOGGLED_STATE", 16, 65536);
      JdW = new d("IS_TOGGLED", 17, 131072);
      JdX = new d("HAS_IMPLICIT_SCROLLING", 18, 262144);
      JdY = new d("IS_READ_ONLY", 19, 1048576);
      JdZ = new d[] { JdF, JdG, JdH, JdI, JdJ, JdK, JdL, JdM, JdN, JdO, JdP, JdQ, JdR, JdS, JdT, JdU, JdV, JdW, JdX, JdY };
      AppMethodBeat.o(9679);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class f
  {
    final a IXS;
    a.c JeA;
    a.c JeB;
    boolean JeC;
    private float[] JeD;
    boolean JeE;
    private float[] JeF;
    Rect JeG;
    int Jea;
    int Jeb;
    int Jec;
    int Jed;
    int Jee;
    int Jef;
    float Jeg;
    float Jeh;
    float Jei;
    String Jej;
    String Jek;
    private a.g Jel;
    boolean Jem;
    private int Jen;
    private int Jeo;
    int Jep;
    int Jeq;
    float Jer;
    private float Jes;
    private float Jet;
    String Jeu;
    String Jev;
    f Jew;
    List<f> Jex;
    List<f> Jey;
    List<a.c> Jez;
    private float bottom;
    int flags;
    String hint;
    int id;
    String label;
    private float left;
    private float right;
    private float top;
    private float[] transform;
    String value;
    
    f(a parama)
    {
      AppMethodBeat.i(9803);
      this.id = -1;
      this.Jem = false;
      this.Jex = new ArrayList();
      this.Jey = new ArrayList();
      this.JeC = true;
      this.JeE = true;
      this.IXS = parama;
      AppMethodBeat.o(9803);
    }
    
    static boolean a(f paramf, c<f> paramc)
    {
      AppMethodBeat.i(9802);
      if (paramf != null)
      {
        paramf = paramf.Jew;
        if (paramf != null) {
          if (!paramc.test(paramf)) {}
        }
        for (;;)
        {
          if (paramf == null) {
            break label54;
          }
          AppMethodBeat.o(9802);
          return true;
          paramf = paramf.Jew;
          break;
          paramf = null;
        }
      }
      label54:
      AppMethodBeat.o(9802);
      return false;
    }
    
    private static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      AppMethodBeat.i(9809);
      Matrix.multiplyMV(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat3, 0);
      float f = paramArrayOfFloat1[3];
      paramArrayOfFloat1[0] /= f;
      paramArrayOfFloat1[1] /= f;
      paramArrayOfFloat1[2] /= f;
      paramArrayOfFloat1[3] = 0.0F;
      AppMethodBeat.o(9809);
    }
    
    private static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9811);
      paramFloat1 = Math.max(paramFloat1, Math.max(paramFloat2, Math.max(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9811);
      return paramFloat1;
    }
    
    private String fvo()
    {
      int i = 0;
      AppMethodBeat.i(9812);
      Object localObject = new StringBuilder();
      String str1 = this.value;
      String str2 = this.label;
      String str3 = this.hint;
      while (i < 3)
      {
        String str4 = new String[] { str1, str2, str3 }[i];
        if ((str4 != null) && (str4.length() > 0))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(", ");
          }
          ((StringBuilder)localObject).append(str4);
        }
        i += 1;
      }
      if (((StringBuilder)localObject).length() > 0)
      {
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(9812);
        return localObject;
      }
      AppMethodBeat.o(9812);
      return null;
    }
    
    private static float m(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    final void a(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.Jem = true;
      this.Jeu = this.value;
      this.Jev = this.label;
      this.Jen = this.flags;
      this.Jeo = this.Jea;
      this.Jep = this.Jeb;
      this.Jeq = this.Jec;
      this.Jer = this.Jeg;
      this.Jes = this.Jeh;
      this.Jet = this.Jei;
      this.flags = paramByteBuffer.getInt();
      this.Jea = paramByteBuffer.getInt();
      this.Jeb = paramByteBuffer.getInt();
      this.Jec = paramByteBuffer.getInt();
      this.Jed = paramByteBuffer.getInt();
      this.Jee = paramByteBuffer.getInt();
      this.Jef = paramByteBuffer.getInt();
      this.Jeg = paramByteBuffer.getFloat();
      this.Jeh = paramByteBuffer.getFloat();
      this.Jei = paramByteBuffer.getFloat();
      int i = paramByteBuffer.getInt();
      String str;
      if (i == -1)
      {
        str = null;
        this.label = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label347;
        }
        str = null;
        label195:
        this.value = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label355;
        }
        str = null;
        label214:
        this.Jej = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label363;
        }
        str = null;
        label233:
        this.Jek = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label371;
        }
      }
      label347:
      label355:
      label363:
      label371:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.Jel = a.g.adK(paramByteBuffer.getInt());
        this.left = paramByteBuffer.getFloat();
        this.top = paramByteBuffer.getFloat();
        this.right = paramByteBuffer.getFloat();
        this.bottom = paramByteBuffer.getFloat();
        if (this.transform == null) {
          this.transform = new float[16];
        }
        i = 0;
        while (i < 16)
        {
          this.transform[i] = paramByteBuffer.getFloat();
          i += 1;
        }
        str = paramArrayOfString[i];
        break;
        str = paramArrayOfString[i];
        break label195;
        str = paramArrayOfString[i];
        break label214;
        str = paramArrayOfString[i];
        break label233;
      }
      this.JeC = true;
      this.JeE = true;
      int j = paramByteBuffer.getInt();
      this.Jex.clear();
      this.Jey.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.IXS, paramByteBuffer.getInt());
        paramArrayOfString.Jew = this;
        this.Jex.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.IXS, paramByteBuffer.getInt());
        paramArrayOfString.Jew = this;
        this.Jey.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.Jez = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.Jez == null)
      {
        this.Jez = new ArrayList(j);
        i = 0;
        label543:
        if (i >= j) {
          break label644;
        }
        paramArrayOfString = a.c(this.IXS, paramByteBuffer.getInt());
        if (paramArrayOfString.JdE != a.b.Jdi.value) {
          break label609;
        }
        this.JeA = paramArrayOfString;
      }
      for (;;)
      {
        this.Jez.add(paramArrayOfString);
        i += 1;
        break label543;
        this.Jez.clear();
        break;
        label609:
        if (paramArrayOfString.JdE == a.b.Jdj.value) {
          this.JeB = paramArrayOfString;
        } else {
          this.Jez.add(paramArrayOfString);
        }
      }
      label644:
      AppMethodBeat.o(9804);
    }
    
    final void a(float[] paramArrayOfFloat, Set<f> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.JeE) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.JeF == null) {
          this.JeF = new float[16];
        }
        Matrix.multiplyMM(this.JeF, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat1, this.JeF, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat2, this.JeF, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat3, this.JeF, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat4, this.JeF, paramArrayOfFloat);
        if (this.JeG == null) {
          this.JeG = new Rect();
        }
        this.JeG.set(Math.round(m(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(m(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(d(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(d(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.JeE = false;
      }
      paramArrayOfFloat = this.Jex.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((f)paramArrayOfFloat.next()).a(this.JeF, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    final boolean a(a.b paramb)
    {
      return (this.Jea & paramb.value) != 0;
    }
    
    final boolean a(a.d paramd)
    {
      return (this.flags & paramd.value) != 0;
    }
    
    final boolean b(a.b paramb)
    {
      return (this.Jeo & paramb.value) != 0;
    }
    
    final boolean b(a.d paramd)
    {
      return (this.Jen & paramd.value) != 0;
    }
    
    final String fvn()
    {
      AppMethodBeat.i(9807);
      if ((a(a.d.JdR)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.Jex.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((f)((Iterator)localObject).next()).fvn();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    final void iv(List<f> paramList)
    {
      AppMethodBeat.i(9806);
      if (a(a.d.JdQ)) {
        paramList.add(this);
      }
      Iterator localIterator = this.Jex.iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).iv(paramList);
      }
      AppMethodBeat.o(9806);
    }
    
    final f r(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(9805);
      float f2 = paramArrayOfFloat[3];
      float f1 = paramArrayOfFloat[0] / f2;
      f2 = paramArrayOfFloat[1] / f2;
      if ((f1 < this.left) || (f1 >= this.right) || (f2 < this.top) || (f2 >= this.bottom))
      {
        AppMethodBeat.o(9805);
        return null;
      }
      float[] arrayOfFloat = new float[4];
      Iterator localIterator = this.Jey.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.a(a.d.JdS))
        {
          if (localf.JeC)
          {
            localf.JeC = false;
            if (localf.JeD == null) {
              localf.JeD = new float[16];
            }
            if (!Matrix.invertM(localf.JeD, 0, localf.transform, 0)) {
              Arrays.fill(localf.JeD, 0.0F);
            }
          }
          Matrix.multiplyMV(arrayOfFloat, 0, localf.JeD, 0, paramArrayOfFloat, 0);
          localf = localf.r(arrayOfFloat);
          if (localf != null)
          {
            AppMethodBeat.o(9805);
            return localf;
          }
        }
      }
      AppMethodBeat.o(9805);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.view.a
 * JD-Core Version:    0.7.0.1
 */