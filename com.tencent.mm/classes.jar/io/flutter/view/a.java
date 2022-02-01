package io.flutter.view;

import android.annotation.SuppressLint;
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
import io.flutter.a.c;
import io.flutter.b;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.g;
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
  private static int aawE = 267386881;
  private final io.flutter.embedding.engine.b.a aapW;
  public e aaps;
  public final AccessibilityViewEmbedder aawF;
  final g aawG;
  private final ContentResolver aawH;
  final Map<Integer, f> aawI;
  private final Map<Integer, c> aawJ;
  public f aawK;
  public Integer aawL;
  public Integer aawM;
  private int aawN;
  public f aawO;
  f aawP;
  public f aawQ;
  final List<Integer> aawR;
  int aawS;
  Integer aawT;
  private final io.flutter.embedding.engine.b.a.a aawU;
  private final AccessibilityManager.AccessibilityStateChangeListener aawV;
  @TargetApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener aawW;
  private final ContentObserver aawX;
  public final AccessibilityManager bEA;
  private boolean isReleased;
  final View rootAccessibilityView;
  
  public a(View paramView, io.flutter.embedding.engine.b.a parama, AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, g paramg)
  {
    this(paramView, parama, paramAccessibilityManager, paramContentResolver, new AccessibilityViewEmbedder(paramView, 65536), paramg);
    AppMethodBeat.i(9750);
    AppMethodBeat.o(9750);
  }
  
  private a(View paramView, io.flutter.embedding.engine.b.a parama, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, AccessibilityViewEmbedder paramAccessibilityViewEmbedder, g paramg)
  {
    AppMethodBeat.i(254441);
    this.aawI = new HashMap();
    this.aawJ = new HashMap();
    this.aawN = 0;
    this.aawR = new ArrayList();
    this.aawS = 0;
    this.aawT = Integer.valueOf(0);
    this.isReleased = false;
    this.aawU = new io.flutter.embedding.engine.b.a.a()
    {
      public final void aDl(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        a.a(a.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public final void aDm(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        a.a(a.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public final void bGg(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        a.b(a.this).announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public final void bGh(String paramAnonymousString)
      {
        AppMethodBeat.i(9691);
        AccessibilityEvent localAccessibilityEvent = a.c(a.this);
        localAccessibilityEvent.getText().add(paramAnonymousString);
        a.a(a.this, localAccessibilityEvent);
        AppMethodBeat.o(9691);
      }
      
      public final void updateCustomAccessibilityActions(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9692);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        a locala = a.this;
        if (paramAnonymousByteBuffer.hasRemaining())
        {
          a.c localc = locala.aDA(paramAnonymousByteBuffer.getInt());
          localc.aaxA = paramAnonymousByteBuffer.getInt();
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
          localObject2 = locala.aDz(paramAnonymousByteBuffer.getInt());
          ((a.f)localObject2).a(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
          if (!((a.f)localObject2).a(a.d.aaxO))
          {
            if (((a.f)localObject2).a(a.d.aaxG)) {
              locala.aawO = ((a.f)localObject2);
            }
            if (((a.f)localObject2).aayl) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        Object localObject2 = new HashSet();
        paramAnonymousByteBuffer = locala.iBz();
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousByteBuffer != null)
        {
          paramAnonymousArrayOfString = new float[16];
          Matrix.setIdentityM(paramAnonymousArrayOfString, 0);
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject3 = locala.rootAccessibilityView.getRootWindowInsets();
            if (localObject3 != null)
            {
              if (!locala.aawT.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
              {
                paramAnonymousByteBuffer.aayD = true;
                paramAnonymousByteBuffer.aayB = true;
              }
              locala.aawT = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
              Matrix.translateM(paramAnonymousArrayOfString, 0, locala.aawT.intValue(), 0.0F, 0.0F);
            }
          }
          paramAnonymousByteBuffer.a(paramAnonymousArrayOfString, (Set)localObject2, false);
          paramAnonymousByteBuffer.lj(localArrayList);
        }
        paramAnonymousByteBuffer = null;
        Object localObject3 = localArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramAnonymousArrayOfString = (a.f)((Iterator)localObject3).next();
          if (locala.aawR.contains(Integer.valueOf(paramAnonymousArrayOfString.id))) {
            break label1573;
          }
          paramAnonymousByteBuffer = paramAnonymousArrayOfString;
        }
        label913:
        label1316:
        label1573:
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
          if ((paramAnonymousArrayOfString != null) && ((paramAnonymousArrayOfString.id != locala.aawS) || (localArrayList.size() != locala.aawR.size())))
          {
            locala.aawS = paramAnonymousArrayOfString.id;
            localObject3 = locala.op(paramAnonymousArrayOfString.id, 32);
            paramAnonymousArrayOfString = paramAnonymousArrayOfString.iBC();
            paramAnonymousByteBuffer = paramAnonymousArrayOfString;
            if (paramAnonymousArrayOfString == null) {
              paramAnonymousByteBuffer = " ";
            }
            ((AccessibilityEvent)localObject3).getText().add(paramAnonymousByteBuffer);
            locala.a((AccessibilityEvent)localObject3);
          }
          locala.aawR.clear();
          paramAnonymousByteBuffer = localArrayList.iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)paramAnonymousByteBuffer.next();
            locala.aawR.add(Integer.valueOf(paramAnonymousArrayOfString.id));
          }
          paramAnonymousByteBuffer = locala.aawI.entrySet().iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)((Map.Entry)paramAnonymousByteBuffer.next()).getValue();
            if (!((Set)localObject2).contains(paramAnonymousArrayOfString))
            {
              paramAnonymousArrayOfString.aayv = null;
              if ((paramAnonymousArrayOfString.aayc != -1) && (locala.aawL != null) && (locala.aawF.platformViewOfNode(locala.aawL.intValue()) == locala.aawG.z(Integer.valueOf(paramAnonymousArrayOfString.aayc))))
              {
                locala.oo(locala.aawL.intValue(), 65536);
                locala.aawL = null;
              }
              if (locala.aawK == paramAnonymousArrayOfString)
              {
                locala.oo(locala.aawK.id, 65536);
                locala.aawK = null;
              }
              if (locala.aawO == paramAnonymousArrayOfString) {
                locala.aawO = null;
              }
              if (locala.aawQ == paramAnonymousArrayOfString) {
                locala.aawQ = null;
              }
              paramAnonymousByteBuffer.remove();
            }
          }
          locala.aDB(0);
          localObject1 = ((ArrayList)localObject1).iterator();
          int i;
          label756:
          float f3;
          float f2;
          float f1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f)((Iterator)localObject1).next();
            if ((!Float.isNaN(((a.f)localObject2).aayf)) && (!Float.isNaN(((a.f)localObject2).aayq)) && (((a.f)localObject2).aayq != ((a.f)localObject2).aayf))
            {
              i = 1;
              if (i == 0) {
                break label1082;
              }
              paramAnonymousByteBuffer = locala.op(((a.f)localObject2).id, 4096);
              f3 = ((a.f)localObject2).aayf;
              f2 = ((a.f)localObject2).aayg;
              f1 = f3;
              if (Float.isInfinite(((a.f)localObject2).aayg))
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
              if (!Float.isInfinite(((a.f)localObject2).aayh)) {
                break label995;
              }
              f3 = f2 + 100000.0F;
              f2 = f1;
              if (f1 < -70000.0F) {
                f2 = -70000.0F;
              }
              f2 += 100000.0F;
              f1 = f3;
              label878:
              if ((!((a.f)localObject2).b(a.b.aaxi)) && (!((a.f)localObject2).b(a.b.aaxj))) {
                break label1024;
              }
              paramAnonymousByteBuffer.setScrollY((int)f2);
              paramAnonymousByteBuffer.setMaxScrollY((int)f1);
              if (((a.f)localObject2).aayd <= 0) {
                break label1076;
              }
              paramAnonymousByteBuffer.setItemCount(((a.f)localObject2).aayd);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).aaye);
              paramAnonymousArrayOfString = ((a.f)localObject2).aayx.iterator();
              i = 0;
              label953:
              if (!paramAnonymousArrayOfString.hasNext()) {
                break label1062;
              }
              if (((a.f)paramAnonymousArrayOfString.next()).a(a.d.aaxO)) {
                break label1570;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break label953;
            i = 0;
            break label756;
            label995:
            f2 -= ((a.f)localObject2).aayh;
            f3 = f1 - ((a.f)localObject2).aayh;
            f1 = f2;
            f2 = f3;
            break label878;
            if ((!((a.f)localObject2).b(a.b.aaxg)) && (!((a.f)localObject2).b(a.b.aaxh))) {
              break label913;
            }
            paramAnonymousByteBuffer.setScrollX((int)f2);
            paramAnonymousByteBuffer.setMaxScrollX((int)f1);
            break label913;
            label1062:
            paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).aaye + i - 1);
            label1076:
            locala.a(paramAnonymousByteBuffer);
            label1082:
            if (((a.f)localObject2).a(a.d.aaxQ))
            {
              if (((((a.f)localObject2).label == null) && (((a.f)localObject2).aayu == null)) || ((((a.f)localObject2).label != null) && (((a.f)localObject2).aayu != null) && (((a.f)localObject2).label.equals(((a.f)localObject2).aayu)))) {
                break label1526;
              }
              i = 1;
              label1144:
              if (i != 0) {
                locala.aDB(((a.f)localObject2).id);
              }
            }
            if ((locala.aawK != null) && (locala.aawK.id == ((a.f)localObject2).id) && (!((a.f)localObject2).b(a.d.aaxD)) && (((a.f)localObject2).a(a.d.aaxD)))
            {
              paramAnonymousByteBuffer = locala.op(((a.f)localObject2).id, 4);
              paramAnonymousByteBuffer.getText().add(((a.f)localObject2).label);
              locala.a(paramAnonymousByteBuffer);
            }
            if ((locala.aawO != null) && (locala.aawO.id == ((a.f)localObject2).id) && ((locala.aawP == null) || (locala.aawP.id != locala.aawO.id)))
            {
              locala.aawP = locala.aawO;
              locala.a(locala.op(((a.f)localObject2).id, 8));
              if ((locala.aawO == null) || (locala.aawO.id != ((a.f)localObject2).id) || (!((a.f)localObject2).b(a.d.aaxF)) || (!((a.f)localObject2).a(a.d.aaxF)) || ((locala.aawK != null) && (locala.aawK.id != locala.aawO.id))) {
                break label1547;
              }
              if (((a.f)localObject2).aayt == null) {
                break label1549;
              }
              paramAnonymousByteBuffer = ((a.f)localObject2).aayt;
              label1403:
              if (((a.f)localObject2).value == null) {
                break label1556;
              }
            }
            for (paramAnonymousArrayOfString = ((a.f)localObject2).value;; paramAnonymousArrayOfString = "")
            {
              paramAnonymousByteBuffer = locala.aj(((a.f)localObject2).id, paramAnonymousByteBuffer, paramAnonymousArrayOfString);
              if (paramAnonymousByteBuffer != null) {
                locala.a(paramAnonymousByteBuffer);
              }
              if ((((a.f)localObject2).aayo == ((a.f)localObject2).aaya) && (((a.f)localObject2).aayp == ((a.f)localObject2).aayb)) {
                break;
              }
              paramAnonymousByteBuffer = locala.op(((a.f)localObject2).id, 8192);
              paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).aaya);
              paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).aayb);
              paramAnonymousByteBuffer.setItemCount(paramAnonymousArrayOfString.length());
              locala.a(paramAnonymousByteBuffer);
              break;
              label1526:
              i = 0;
              break label1144;
              if (locala.aawO != null) {
                break label1316;
              }
              locala.aawP = null;
              break label1316;
              break;
              paramAnonymousByteBuffer = "";
              break label1403;
            }
            AppMethodBeat.o(9693);
            return;
          }
        }
      }
    };
    this.aawV = new AccessibilityManager.AccessibilityStateChangeListener()
    {
      public final void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9797);
        if (a.d(a.this))
        {
          AppMethodBeat.o(9797);
          return;
        }
        if (paramAnonymousBoolean)
        {
          a.f(a.this).a(a.e(a.this));
          a.f(a.this).aapT.setSemanticsEnabled(true);
        }
        for (;;)
        {
          if (a.g(a.this) != null) {
            a.g(a.this).bw(paramAnonymousBoolean, a.h(a.this).isTouchExplorationEnabled());
          }
          AppMethodBeat.o(9797);
          return;
          a.f(a.this).a(null);
          a.f(a.this).aapT.setSemanticsEnabled(false);
        }
      }
    };
    this.aawX = new ContentObserver(new Handler())
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
        if (a.d(a.this))
        {
          AppMethodBeat.o(9777);
          return;
        }
        int i;
        if (Build.VERSION.SDK_INT < 17)
        {
          paramAnonymousUri = null;
          if ((paramAnonymousUri == null) || (!paramAnonymousUri.equals("0"))) {
            break label104;
          }
          i = 1;
          label48:
          if (i == 0) {
            break label109;
          }
          a.a(a.this, a.j(a.this) | a.a.aaxc.value);
        }
        for (;;)
        {
          a.k(a.this);
          AppMethodBeat.o(9777);
          return;
          paramAnonymousUri = Settings.Global.getString(a.i(a.this), "transition_animation_scale");
          break;
          label104:
          i = 0;
          break label48;
          label109:
          a.a(a.this, a.j(a.this) & (a.a.aaxc.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.rootAccessibilityView = paramView;
    this.aapW = parama;
    this.bEA = paramAccessibilityManager;
    this.aawH = paramContentResolver;
    this.aawF = paramAccessibilityViewEmbedder;
    this.aawG = paramg;
    this.aawV.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.bEA.addAccessibilityStateChangeListener(this.aawV);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.aawW = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (a.d(a.this))
          {
            AppMethodBeat.o(9778);
            return;
          }
          if (paramAnonymousBoolean) {
            a.a(a.this, a.j(a.this) | a.a.aaxa.value);
          }
          for (;;)
          {
            a.k(a.this);
            if (a.g(a.this) != null) {
              a.g(a.this).bw(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            a.l(a.this);
            a.a(a.this, a.j(a.this) & (a.a.aaxa.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.aawW.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.bEA.addTouchExplorationStateChangeListener(this.aawW);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.aawX.onChange(false);
        paramView = Settings.Global.getUriFor("transition_animation_scale");
        this.aawH.registerContentObserver(paramView, false, this.aawX);
      }
      if (paramg != null) {
        paramg.a(this);
      }
      AppMethodBeat.o(254441);
      return;
      this.aawW = null;
    }
  }
  
  private boolean a(final f paramf)
  {
    AppMethodBeat.i(9752);
    if ((paramf.aayd > 0) && ((f.a(this.aawK, new c() {})) || (!f.a(this.aawK, new c() {}))))
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
        if ((paramBoolean) && (paramf.a(b.aaxn)))
        {
          this.aapW.dispatchSemanticsAction(paramInt, b.aaxn, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!paramf.a(b.aaxo)));
      this.aapW.dispatchSemanticsAction(paramInt, b.aaxo, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (paramf.a(b.aaxx)))
      {
        this.aapW.dispatchSemanticsAction(paramInt, b.aaxx, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!paramf.a(b.aaxy)));
    this.aapW.dispatchSemanticsAction(paramInt, b.aaxy, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void aO(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.aawI.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    f localf = iBz().s(new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localf != this.aawQ)
    {
      if (localf != null) {
        oo(localf.id, 128);
      }
      if (this.aawQ != null) {
        oo(this.aawQ.id, 256);
      }
      this.aawQ = localf;
    }
    AppMethodBeat.o(9762);
  }
  
  private void iBA()
  {
    AppMethodBeat.i(9761);
    if (this.aawQ != null)
    {
      oo(this.aawQ.id, 256);
      this.aawQ = null;
    }
    AppMethodBeat.o(9761);
  }
  
  final void a(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.bEA.isEnabled())
    {
      AppMethodBeat.o(9765);
      return;
    }
    this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, paramAccessibilityEvent);
    AppMethodBeat.o(9765);
  }
  
  final c aDA(int paramInt)
  {
    AppMethodBeat.i(9759);
    c localc2 = (c)this.aawJ.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      localc1.id = paramInt;
      localc1.Ezt = (aawE + paramInt);
      this.aawJ.put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(9759);
    return localc1;
  }
  
  final void aDB(int paramInt)
  {
    AppMethodBeat.i(254475);
    AccessibilityEvent localAccessibilityEvent = op(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    a(localAccessibilityEvent);
    AppMethodBeat.o(254475);
  }
  
  final f aDz(int paramInt)
  {
    AppMethodBeat.i(9758);
    f localf2 = (f)this.aawI.get(Integer.valueOf(paramInt));
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f(this);
      localf1.id = paramInt;
      this.aawI.put(Integer.valueOf(paramInt), localf1);
    }
    AppMethodBeat.o(9758);
    return localf1;
  }
  
  public final boolean aM(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.bEA.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    if (this.aawI.isEmpty())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    f localf = iBz().s(new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if ((localf != null) && (localf.aayc != -1))
    {
      boolean bool = this.aawF.onAccessibilityHoverEvent(localf.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      aO(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      iBA();
    }
    new StringBuilder("unexpected accessibility hover event: ").append(paramMotionEvent);
    b.iAe();
    AppMethodBeat.o(9760);
    return false;
  }
  
  final AccessibilityEvent aj(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = op(paramInt, 16);
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
  
  @SuppressLint({"NewApi"})
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9753);
    if (paramInt >= 65536)
    {
      localObject1 = this.aawF.createAccessibilityNodeInfo(paramInt);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.aawI.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject2 = (f)this.aawI.get(Integer.valueOf(paramInt));
    if (localObject2 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject3;
    if (((f)localObject2).aayc != -1)
    {
      localObject1 = this.aawG.z(Integer.valueOf(((f)localObject2).aayc));
      if (this.aawG.A(Integer.valueOf(((f)localObject2).aayc)))
      {
        localObject3 = ((f)localObject2).aayF;
        localObject1 = this.aawF.getRootNode((View)localObject1, ((f)localObject2).id, (Rect)localObject3);
        AppMethodBeat.o(9753);
        return localObject1;
      }
    }
    Object localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    if (Build.VERSION.SDK_INT >= 18) {
      ((AccessibilityNodeInfo)localObject1).setViewIdResourceName("");
    }
    ((AccessibilityNodeInfo)localObject1).setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    ((AccessibilityNodeInfo)localObject1).setClassName("android.view.View");
    ((AccessibilityNodeInfo)localObject1).setSource(this.rootAccessibilityView, paramInt);
    ((AccessibilityNodeInfo)localObject1).setFocusable(((f)localObject2).iBB());
    boolean bool1;
    if (this.aawO != null)
    {
      if (this.aawO.id == paramInt)
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject1).setFocused(bool1);
      }
    }
    else
    {
      if (this.aawK != null)
      {
        if (this.aawK.id != paramInt) {
          break label1525;
        }
        bool1 = true;
        label323:
        ((AccessibilityNodeInfo)localObject1).setAccessibilityFocused(bool1);
      }
      if (((f)localObject2).a(d.aaxF))
      {
        ((AccessibilityNodeInfo)localObject1).setPassword(((f)localObject2).a(d.aaxL));
        if (!((f)localObject2).a(d.aaxU)) {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.EditText");
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          if (((f)localObject2).a(d.aaxU)) {
            break label1531;
          }
          bool1 = true;
          label395:
          ((AccessibilityNodeInfo)localObject1).setEditable(bool1);
          if ((((f)localObject2).aaya != -1) && (((f)localObject2).aayb != -1)) {
            ((AccessibilityNodeInfo)localObject1).setTextSelection(((f)localObject2).aaya, ((f)localObject2).aayb);
          }
          if ((Build.VERSION.SDK_INT > 18) && (this.aawK != null) && (this.aawK.id == paramInt)) {
            ((AccessibilityNodeInfo)localObject1).setLiveRegion(1);
          }
        }
        if (!((f)localObject2).a(b.aaxn)) {
          break label1869;
        }
        ((AccessibilityNodeInfo)localObject1).addAction(256);
      }
    }
    label799:
    label959:
    label1609:
    label1740:
    label1869:
    for (int j = 1;; j = 0)
    {
      if (((f)localObject2).a(b.aaxo))
      {
        ((AccessibilityNodeInfo)localObject1).addAction(512);
        j = 1;
      }
      int i = j;
      if (((f)localObject2).a(b.aaxx))
      {
        ((AccessibilityNodeInfo)localObject1).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (((f)localObject2).a(b.aaxy))
      {
        ((AccessibilityNodeInfo)localObject1).addAction(512);
        j = i | 0x2;
      }
      ((AccessibilityNodeInfo)localObject1).setMovementGranularities(j);
      label591:
      Object localObject4;
      label859:
      label1014:
      boolean bool4;
      if ((Build.VERSION.SDK_INT >= 21) && (((f)localObject2).aaxY >= 0))
      {
        if (((f)localObject2).value == null)
        {
          i = 0;
          ((AccessibilityNodeInfo)localObject1).setMaxTextLength(i - ((f)localObject2).aaxZ + ((f)localObject2).aaxY);
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          if (((f)localObject2).a(b.aaxp)) {
            ((AccessibilityNodeInfo)localObject1).addAction(131072);
          }
          if (((f)localObject2).a(b.aaxq)) {
            ((AccessibilityNodeInfo)localObject1).addAction(16384);
          }
          if (((f)localObject2).a(b.aaxr)) {
            ((AccessibilityNodeInfo)localObject1).addAction(65536);
          }
          if (((f)localObject2).a(b.aaxs)) {
            ((AccessibilityNodeInfo)localObject1).addAction(32768);
          }
        }
        if ((((f)localObject2).a(d.aaxE)) || (((f)localObject2).a(d.aaxW))) {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.Button");
        }
        if (((f)localObject2).a(d.aaxP)) {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.ImageView");
        }
        if ((Build.VERSION.SDK_INT > 18) && (((f)localObject2).a(b.aaxw)))
        {
          ((AccessibilityNodeInfo)localObject1).setDismissable(true);
          ((AccessibilityNodeInfo)localObject1).addAction(1048576);
        }
        if (((f)localObject2).aayv == null) {
          break label1549;
        }
        ((AccessibilityNodeInfo)localObject1).setParent(this.rootAccessibilityView, ((f)localObject2).aayv.id);
        localObject3 = ((f)localObject2).aayF;
        if (((f)localObject2).aayv == null) {
          break label1561;
        }
        localObject4 = ((f)localObject2).aayv.aayF;
        Rect localRect = new Rect((Rect)localObject3);
        localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject1).setBoundsInParent(localRect);
        ((AccessibilityNodeInfo)localObject1).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject1).setVisibleToUser(true);
        if ((((f)localObject2).a(d.aaxH)) && (!((f)localObject2).a(d.aaxI))) {
          break label1571;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject1).setEnabled(bool1);
        if (((f)localObject2).a(b.aaxe))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject2).aayz == null)) {
            break label1577;
          }
          ((AccessibilityNodeInfo)localObject1).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, ((f)localObject2).aayz.hint));
          ((AccessibilityNodeInfo)localObject1).setClickable(true);
        }
        if (((f)localObject2).a(b.aaxf))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject2).aayA == null)) {
            break label1593;
          }
          ((AccessibilityNodeInfo)localObject1).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, ((f)localObject2).aayA.hint));
          ((AccessibilityNodeInfo)localObject1).setLongClickable(true);
        }
        if ((((f)localObject2).a(b.aaxg)) || (((f)localObject2).a(b.aaxi)) || (((f)localObject2).a(b.aaxh)) || (((f)localObject2).a(b.aaxj)))
        {
          ((AccessibilityNodeInfo)localObject1).setScrollable(true);
          if (((f)localObject2).a(d.aaxT))
          {
            if ((!((f)localObject2).a(b.aaxg)) && (!((f)localObject2).a(b.aaxh))) {
              break label1620;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!a((f)localObject2))) {
              break label1609;
            }
            ((AccessibilityNodeInfo)localObject1).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((f)localObject2).aayd, false));
          }
          label1129:
          if ((((f)localObject2).a(b.aaxg)) || (((f)localObject2).a(b.aaxi))) {
            ((AccessibilityNodeInfo)localObject1).addAction(4096);
          }
          if ((((f)localObject2).a(b.aaxh)) || (((f)localObject2).a(b.aaxj))) {
            ((AccessibilityNodeInfo)localObject1).addAction(8192);
          }
        }
        if ((((f)localObject2).a(b.aaxk)) || (((f)localObject2).a(b.aaxl)))
        {
          ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.SeekBar");
          if (((f)localObject2).a(b.aaxk)) {
            ((AccessibilityNodeInfo)localObject1).addAction(4096);
          }
          if (((f)localObject2).a(b.aaxl)) {
            ((AccessibilityNodeInfo)localObject1).addAction(8192);
          }
        }
        if ((((f)localObject2).a(d.aaxQ)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject1).setLiveRegion(1);
        }
        if (!((f)localObject2).a(d.aaxF)) {
          break label1666;
        }
        ((AccessibilityNodeInfo)localObject1).setText(f.b((f)localObject2));
        boolean bool3 = ((f)localObject2).a(d.aaxB);
        bool4 = ((f)localObject2).a(d.aaxR);
        if (!bool3)
        {
          bool1 = bool2;
          if (!bool4) {}
        }
        else
        {
          bool1 = true;
        }
        ((AccessibilityNodeInfo)localObject1).setCheckable(bool1);
        if (!bool3) {
          break label1701;
        }
        ((AccessibilityNodeInfo)localObject1).setChecked(((f)localObject2).a(d.aaxC));
        if (!((f)localObject2).a(d.aaxJ)) {
          break label1690;
        }
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.RadioButton");
        label1384:
        ((AccessibilityNodeInfo)localObject1).setSelected(((f)localObject2).a(d.aaxD));
        if (Build.VERSION.SDK_INT >= 28) {
          ((AccessibilityNodeInfo)localObject1).setHeading(((f)localObject2).a(d.aaxK));
        }
        if ((this.aawK == null) || (this.aawK.id != paramInt)) {
          break label1730;
        }
        ((AccessibilityNodeInfo)localObject1).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((f)localObject2).aayy == null)) {
          break label1740;
        }
        localObject3 = ((f)localObject2).aayy.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject1).addAction(new AccessibilityNodeInfo.AccessibilityAction(((c)localObject4).Ezt, ((c)localObject4).label));
        }
        bool1 = false;
        break;
        label1525:
        bool1 = false;
        break label323;
        label1531:
        bool1 = false;
        break label395;
        i = ((f)localObject2).value.length();
        break label591;
        ((AccessibilityNodeInfo)localObject1).setParent(this.rootAccessibilityView);
        break label799;
        ((AccessibilityNodeInfo)localObject1).setBoundsInParent((Rect)localObject3);
        break label859;
        bool1 = false;
        break label897;
        ((AccessibilityNodeInfo)localObject1).addAction(16);
        ((AccessibilityNodeInfo)localObject1).setClickable(true);
        break label959;
        ((AccessibilityNodeInfo)localObject1).addAction(32);
        ((AccessibilityNodeInfo)localObject1).setLongClickable(true);
        break label1014;
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.HorizontalScrollView");
        break label1129;
        label1620:
        if ((Build.VERSION.SDK_INT > 18) && (a((f)localObject2)))
        {
          ((AccessibilityNodeInfo)localObject1).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((f)localObject2).aayd, 0, false));
          break label1129;
        }
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.ScrollView");
        break label1129;
        if (((f)localObject2).a(d.aaxM)) {
          break label1303;
        }
        ((AccessibilityNodeInfo)localObject1).setContentDescription(f.b((f)localObject2));
        break label1303;
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.CheckBox");
        break label1384;
        if (!bool4) {
          break label1384;
        }
        ((AccessibilityNodeInfo)localObject1).setChecked(((f)localObject2).a(d.aaxS));
        ((AccessibilityNodeInfo)localObject1).setClassName("android.widget.Switch");
        break label1384;
        ((AccessibilityNodeInfo)localObject1).addAction(64);
      }
      localObject2 = ((f)localObject2).aayw.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f)((Iterator)localObject2).next();
        if (!((f)localObject3).a(d.aaxO))
        {
          if (((f)localObject3).aayc != -1)
          {
            localObject4 = this.aawG.z(Integer.valueOf(((f)localObject3).aayc));
            if (!this.aawG.A(Integer.valueOf(((f)localObject3).aayc)))
            {
              ((AccessibilityNodeInfo)localObject1).addChild((View)localObject4);
              continue;
            }
          }
          ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, ((f)localObject3).id);
        }
      }
      AppMethodBeat.o(9753);
      return localObject1;
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
      if (this.aawO != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.aawO.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.aawM != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.aawM.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.aawK != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.aawK.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.aawL == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.aawL.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  final f iBz()
  {
    AppMethodBeat.i(9757);
    f localf = (f)this.aawI.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localf;
  }
  
  final void oo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.bEA.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    a(op(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  final AccessibilityEvent op(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9766);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityEvent.setSource(this.rootAccessibilityView, paramInt1);
    AppMethodBeat.o(9766);
    return localAccessibilityEvent;
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(9754);
    boolean bool;
    if (paramInt1 >= 65536)
    {
      bool = this.aawF.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.aawL = null;
      }
      AppMethodBeat.o(9754);
      return bool;
    }
    f localf = (f)this.aawI.get(Integer.valueOf(paramInt1));
    if (localf == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = aawE;
      paramBundle = (c)this.aawJ.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.aapW.dispatchSemanticsAction(paramInt1, b.aaxv, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxe);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxf);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (localf.a(b.aaxi)) {
        this.aapW.dispatchSemanticsAction(paramInt1, b.aaxi);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.aaxg))
        {
          this.aapW.dispatchSemanticsAction(paramInt1, b.aaxg);
        }
        else
        {
          if (!localf.a(b.aaxk)) {
            break;
          }
          localf.value = localf.aayi;
          oo(paramInt1, 4);
          this.aapW.dispatchSemanticsAction(paramInt1, b.aaxk);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (localf.a(b.aaxj)) {
        this.aapW.dispatchSemanticsAction(paramInt1, b.aaxj);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.aaxh))
        {
          this.aapW.dispatchSemanticsAction(paramInt1, b.aaxh);
        }
        else
        {
          if (!localf.a(b.aaxl)) {
            break;
          }
          localf.value = localf.aayj;
          oo(paramInt1, 4);
          this.aapW.dispatchSemanticsAction(paramInt1, b.aaxl);
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
      bool = a(localf, paramInt1, paramBundle, false);
      AppMethodBeat.o(9754);
      return bool;
    case 256: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = a(localf, paramInt1, paramBundle, true);
      AppMethodBeat.o(9754);
      return bool;
    case 128: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxu);
      oo(paramInt1, 65536);
      this.aawK = null;
      this.aawL = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxt);
      oo(paramInt1, 32768);
      if (this.aawK == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.aawK = localf;
      if ((localf.a(b.aaxk)) || (localf.a(b.aaxl))) {
        oo(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxm);
      AppMethodBeat.o(9754);
      return true;
    case 131072: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      HashMap localHashMap = new HashMap();
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
        localHashMap.put("base", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
        localHashMap.put("extent", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
      }
      for (;;)
      {
        this.aapW.dispatchSemanticsAction(paramInt1, b.aaxp, localHashMap);
        AppMethodBeat.o(9754);
        return true;
        localHashMap.put("base", Integer.valueOf(localf.aayb));
        localHashMap.put("extent", Integer.valueOf(localf.aayb));
      }
    case 16384: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxq);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxr);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxs);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.aapW.dispatchSemanticsAction(paramInt1, b.aaxw);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(9751);
    this.isReleased = true;
    if (this.aawG != null) {
      this.aawG.iBu();
    }
    this.aaps = null;
    this.bEA.removeAccessibilityStateChangeListener(this.aawV);
    if (Build.VERSION.SDK_INT >= 19) {
      this.bEA.removeTouchExplorationStateChangeListener(this.aawW);
    }
    this.aawH.unregisterContentObserver(this.aawX);
    this.aapW.a(null);
    AppMethodBeat.o(9751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(9767);
    this.aawI.clear();
    if (this.aawK != null) {
      oo(this.aawK.id, 65536);
    }
    this.aawK = null;
    this.aawQ = null;
    aDB(0);
    AppMethodBeat.o(9767);
  }
  
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(9783);
      aaxe = new b("TAP", 0, 1);
      aaxf = new b("LONG_PRESS", 1, 2);
      aaxg = new b("SCROLL_LEFT", 2, 4);
      aaxh = new b("SCROLL_RIGHT", 3, 8);
      aaxi = new b("SCROLL_UP", 4, 16);
      aaxj = new b("SCROLL_DOWN", 5, 32);
      aaxk = new b("INCREASE", 6, 64);
      aaxl = new b("DECREASE", 7, 128);
      aaxm = new b("SHOW_ON_SCREEN", 8, 256);
      aaxn = new b("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      aaxo = new b("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      aaxp = new b("SET_SELECTION", 11, 2048);
      aaxq = new b("COPY", 12, 4096);
      aaxr = new b("CUT", 13, 8192);
      aaxs = new b("PASTE", 14, 16384);
      aaxt = new b("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      aaxu = new b("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      aaxv = new b("CUSTOM_ACTION", 17, 131072);
      aaxw = new b("DISMISS", 18, 262144);
      aaxx = new b("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      aaxy = new b("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      aaxz = new b[] { aaxe, aaxf, aaxg, aaxh, aaxi, aaxj, aaxk, aaxl, aaxm, aaxn, aaxo, aaxp, aaxq, aaxr, aaxs, aaxt, aaxu, aaxv, aaxw, aaxx, aaxy };
      AppMethodBeat.o(9783);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class c
  {
    int Ezt = -1;
    int aaxA = -1;
    String hint;
    int id = -1;
    String label;
  }
  
  static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(9679);
      aaxB = new d("HAS_CHECKED_STATE", 0, 1);
      aaxC = new d("IS_CHECKED", 1, 2);
      aaxD = new d("IS_SELECTED", 2, 4);
      aaxE = new d("IS_BUTTON", 3, 8);
      aaxF = new d("IS_TEXT_FIELD", 4, 16);
      aaxG = new d("IS_FOCUSED", 5, 32);
      aaxH = new d("HAS_ENABLED_STATE", 6, 64);
      aaxI = new d("IS_ENABLED", 7, 128);
      aaxJ = new d("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      aaxK = new d("IS_HEADER", 9, 512);
      aaxL = new d("IS_OBSCURED", 10, 1024);
      aaxM = new d("SCOPES_ROUTE", 11, 2048);
      aaxN = new d("NAMES_ROUTE", 12, 4096);
      aaxO = new d("IS_HIDDEN", 13, 8192);
      aaxP = new d("IS_IMAGE", 14, 16384);
      aaxQ = new d("IS_LIVE_REGION", 15, 32768);
      aaxR = new d("HAS_TOGGLED_STATE", 16, 65536);
      aaxS = new d("IS_TOGGLED", 17, 131072);
      aaxT = new d("HAS_IMPLICIT_SCROLLING", 18, 262144);
      aaxU = new d("IS_READ_ONLY", 19, 1048576);
      aaxV = new d("IS_FOCUSABLE", 20, 2097152);
      aaxW = new d("IS_LINK", 21, 4194304);
      aaxX = new d[] { aaxB, aaxC, aaxD, aaxE, aaxF, aaxG, aaxH, aaxI, aaxJ, aaxK, aaxL, aaxM, aaxN, aaxO, aaxP, aaxQ, aaxR, aaxS, aaxT, aaxU, aaxV, aaxW };
      AppMethodBeat.o(9679);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface e
  {
    public abstract void bw(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  static final class f
  {
    final a aapq;
    int aaxY;
    int aaxZ;
    a.c aayA;
    boolean aayB;
    private float[] aayC;
    boolean aayD;
    private float[] aayE;
    Rect aayF;
    int aaya;
    int aayb;
    int aayc;
    int aayd;
    int aaye;
    float aayf;
    float aayg;
    float aayh;
    String aayi;
    String aayj;
    private a.g aayk;
    boolean aayl;
    private int aaym;
    private int aayn;
    int aayo;
    int aayp;
    float aayq;
    private float aayr;
    private float aays;
    String aayt;
    String aayu;
    f aayv;
    List<f> aayw;
    List<f> aayx;
    List<a.c> aayy;
    a.c aayz;
    private int actions;
    private float bottom;
    private int flags;
    private String hint;
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
      this.aayl = false;
      this.aayw = new ArrayList();
      this.aayx = new ArrayList();
      this.aayB = true;
      this.aayD = true;
      this.aapq = parama;
      AppMethodBeat.o(9803);
    }
    
    static boolean a(f paramf, c<f> paramc)
    {
      AppMethodBeat.i(9802);
      if (paramf != null)
      {
        paramf = paramf.aayv;
        if (paramf != null) {
          if (!paramc.eX(paramf)) {}
        }
        for (;;)
        {
          if (paramf == null) {
            break label54;
          }
          AppMethodBeat.o(9802);
          return true;
          paramf = paramf.aayv;
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
    
    private String iBD()
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
    
    private static float j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9811);
      paramFloat1 = Math.max(paramFloat1, Math.max(paramFloat2, Math.max(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9811);
      return paramFloat1;
    }
    
    private static float w(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    final void a(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.aayl = true;
      this.aayt = this.value;
      this.aayu = this.label;
      this.aaym = this.flags;
      this.aayn = this.actions;
      this.aayo = this.aaya;
      this.aayp = this.aayb;
      this.aayq = this.aayf;
      this.aayr = this.aayg;
      this.aays = this.aayh;
      this.flags = paramByteBuffer.getInt();
      this.actions = paramByteBuffer.getInt();
      this.aaxY = paramByteBuffer.getInt();
      this.aaxZ = paramByteBuffer.getInt();
      this.aaya = paramByteBuffer.getInt();
      this.aayb = paramByteBuffer.getInt();
      this.aayc = paramByteBuffer.getInt();
      this.aayd = paramByteBuffer.getInt();
      this.aaye = paramByteBuffer.getInt();
      this.aayf = paramByteBuffer.getFloat();
      this.aayg = paramByteBuffer.getFloat();
      this.aayh = paramByteBuffer.getFloat();
      int i = paramByteBuffer.getInt();
      String str;
      if (i == -1)
      {
        str = null;
        this.label = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label363;
        }
        str = null;
        label211:
        this.value = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label371;
        }
        str = null;
        label230:
        this.aayi = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label379;
        }
        str = null;
        label249:
        this.aayj = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label387;
        }
      }
      label387:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.aayk = a.g.aDC(paramByteBuffer.getInt());
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
        label363:
        str = paramArrayOfString[i];
        break label211;
        label371:
        str = paramArrayOfString[i];
        break label230;
        label379:
        str = paramArrayOfString[i];
        break label249;
      }
      this.aayB = true;
      this.aayD = true;
      int j = paramByteBuffer.getInt();
      this.aayw.clear();
      this.aayx.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.aapq, paramByteBuffer.getInt());
        paramArrayOfString.aayv = this;
        this.aayw.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.aapq, paramByteBuffer.getInt());
        paramArrayOfString.aayv = this;
        this.aayx.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.aayy = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.aayy == null)
      {
        this.aayy = new ArrayList(j);
        i = 0;
        label559:
        if (i >= j) {
          break label660;
        }
        paramArrayOfString = a.c(this.aapq, paramByteBuffer.getInt());
        if (paramArrayOfString.aaxA != a.b.aaxe.value) {
          break label625;
        }
        this.aayz = paramArrayOfString;
      }
      for (;;)
      {
        this.aayy.add(paramArrayOfString);
        i += 1;
        break label559;
        this.aayy.clear();
        break;
        label625:
        if (paramArrayOfString.aaxA == a.b.aaxf.value) {
          this.aayA = paramArrayOfString;
        } else {
          this.aayy.add(paramArrayOfString);
        }
      }
      label660:
      AppMethodBeat.o(9804);
    }
    
    final void a(float[] paramArrayOfFloat, Set<f> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.aayD) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.aayE == null) {
          this.aayE = new float[16];
        }
        Matrix.multiplyMM(this.aayE, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat1, this.aayE, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat2, this.aayE, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat3, this.aayE, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat4, this.aayE, paramArrayOfFloat);
        if (this.aayF == null) {
          this.aayF = new Rect();
        }
        this.aayF.set(Math.round(w(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(w(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(j(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(j(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.aayD = false;
      }
      paramArrayOfFloat = this.aayw.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((f)paramArrayOfFloat.next()).a(this.aayE, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    final boolean a(a.b paramb)
    {
      return (this.actions & paramb.value) != 0;
    }
    
    final boolean a(a.d paramd)
    {
      return (this.flags & paramd.value) != 0;
    }
    
    final boolean b(a.b paramb)
    {
      return (this.aayn & paramb.value) != 0;
    }
    
    final boolean b(a.d paramd)
    {
      return (this.aaym & paramd.value) != 0;
    }
    
    final boolean iBB()
    {
      AppMethodBeat.i(254582);
      if (a(a.d.aaxM))
      {
        AppMethodBeat.o(254582);
        return false;
      }
      if (a(a.d.aaxV))
      {
        AppMethodBeat.o(254582);
        return true;
      }
      if (((((a.b.aaxh.value | a.b.aaxg.value | a.b.aaxi.value | a.b.aaxj.value) ^ 0xFFFFFFFF) & this.actions) != 0) || (this.flags != 0) || ((this.label != null) && (!this.label.isEmpty())) || ((this.value != null) && (!this.value.isEmpty())) || ((this.hint != null) && (!this.hint.isEmpty())))
      {
        AppMethodBeat.o(254582);
        return true;
      }
      AppMethodBeat.o(254582);
      return false;
    }
    
    final String iBC()
    {
      AppMethodBeat.i(9807);
      if ((a(a.d.aaxN)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.aayw.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((f)((Iterator)localObject).next()).iBC();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    final void lj(List<f> paramList)
    {
      AppMethodBeat.i(9806);
      if (a(a.d.aaxM)) {
        paramList.add(this);
      }
      Iterator localIterator = this.aayw.iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).lj(paramList);
      }
      AppMethodBeat.o(9806);
    }
    
    final f s(float[] paramArrayOfFloat)
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
      Iterator localIterator = this.aayx.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.a(a.d.aaxO))
        {
          if (localf.aayB)
          {
            localf.aayB = false;
            if (localf.aayC == null) {
              localf.aayC = new float[16];
            }
            if (!Matrix.invertM(localf.aayC, 0, localf.transform, 0)) {
              Arrays.fill(localf.aayC, 0.0F);
            }
          }
          Matrix.multiplyMV(arrayOfFloat, 0, localf.aayC, 0, paramArrayOfFloat, 0);
          localf = localf.s(arrayOfFloat);
          if (localf != null)
          {
            AppMethodBeat.o(9805);
            return localf;
          }
        }
      }
      if (iBB())
      {
        AppMethodBeat.o(9805);
        return this;
      }
      AppMethodBeat.o(9805);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.a
 * JD-Core Version:    0.7.0.1
 */