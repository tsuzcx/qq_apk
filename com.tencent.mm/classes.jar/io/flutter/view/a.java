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
import io.flutter.b.c;
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
  private static int MHe = 267386881;
  public e MBS;
  private final io.flutter.embedding.engine.c.a MCj;
  public final AccessibilityViewEmbedder MHf;
  private final g MHg;
  final Map<Integer, f> MHh;
  private final Map<Integer, c> MHi;
  public f MHj;
  public Integer MHk;
  public Integer MHl;
  private int MHm;
  public f MHn;
  f MHo;
  public f MHp;
  final List<Integer> MHq;
  int MHr;
  Integer MHs;
  private final io.flutter.embedding.engine.c.a.a MHt;
  private final AccessibilityManager.AccessibilityStateChangeListener MHu;
  @TargetApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener MHv;
  private final ContentObserver MHw;
  private final ContentResolver aFz;
  public final AccessibilityManager nA;
  final View rootAccessibilityView;
  
  public a(View paramView, io.flutter.embedding.engine.c.a parama, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, g paramg)
  {
    AppMethodBeat.i(9750);
    this.MHh = new HashMap();
    this.MHi = new HashMap();
    this.MHm = 0;
    this.MHq = new ArrayList();
    this.MHr = 0;
    this.MHs = Integer.valueOf(0);
    this.MHt = new io.flutter.embedding.engine.c.a.a()
    {
      public final void aiX(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        a.a(a.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public final void aiY(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        a.a(a.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public final void bbM(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        a.b(a.this).announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public final void bbN(String paramAnonymousString)
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
          a.c localc = locala.ajf(paramAnonymousByteBuffer.getInt());
          localc.MIa = paramAnonymousByteBuffer.getInt();
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
          localObject2 = locala.aje(paramAnonymousByteBuffer.getInt());
          ((a.f)localObject2).a(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
          if (!((a.f)localObject2).a(a.d.MIo))
          {
            if (((a.f)localObject2).a(a.d.MIg)) {
              locala.MHn = ((a.f)localObject2);
            }
            if (((a.f)localObject2).MIM) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        Object localObject2 = new HashSet();
        paramAnonymousByteBuffer = locala.gfq();
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
              if (!locala.MHs.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
              {
                paramAnonymousByteBuffer.MJe = true;
                paramAnonymousByteBuffer.MJc = true;
              }
              locala.MHs = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
              Matrix.translateM(paramAnonymousArrayOfString, 0, locala.MHs.intValue(), 0.0F, 0.0F);
            }
          }
          paramAnonymousByteBuffer.a(paramAnonymousArrayOfString, (Set)localObject2, false);
          paramAnonymousByteBuffer.iZ(localArrayList);
        }
        paramAnonymousByteBuffer = null;
        Object localObject3 = localArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramAnonymousArrayOfString = (a.f)((Iterator)localObject3).next();
          if (locala.MHq.contains(Integer.valueOf(paramAnonymousArrayOfString.id))) {
            break label1467;
          }
          paramAnonymousByteBuffer = paramAnonymousArrayOfString;
        }
        label650:
        label807:
        label1210:
        label1467:
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
          if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.id != locala.MHr))
          {
            locala.MHr = paramAnonymousArrayOfString.id;
            paramAnonymousByteBuffer = locala.ll(paramAnonymousArrayOfString.id, 32);
            paramAnonymousArrayOfString = paramAnonymousArrayOfString.gfs();
            paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
          }
          locala.MHq.clear();
          paramAnonymousByteBuffer = localArrayList.iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)paramAnonymousByteBuffer.next();
            locala.MHq.add(Integer.valueOf(paramAnonymousArrayOfString.id));
          }
          paramAnonymousByteBuffer = locala.MHh.entrySet().iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)((Map.Entry)paramAnonymousByteBuffer.next()).getValue();
            if (!((Set)localObject2).contains(paramAnonymousArrayOfString))
            {
              paramAnonymousArrayOfString.MIW = null;
              if (locala.MHj == paramAnonymousArrayOfString)
              {
                locala.lk(locala.MHj.id, 65536);
                locala.MHj = null;
              }
              if (locala.MHn == paramAnonymousArrayOfString) {
                locala.MHn = null;
              }
              if (locala.MHp == paramAnonymousArrayOfString) {
                locala.MHp = null;
              }
              paramAnonymousByteBuffer.remove();
            }
          }
          locala.ajg(0);
          localObject1 = ((ArrayList)localObject1).iterator();
          int i;
          float f3;
          float f2;
          float f1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f)((Iterator)localObject1).next();
            if ((!Float.isNaN(((a.f)localObject2).MIG)) && (!Float.isNaN(((a.f)localObject2).MIR)) && (((a.f)localObject2).MIR != ((a.f)localObject2).MIG))
            {
              i = 1;
              if (i == 0) {
                break label976;
              }
              paramAnonymousByteBuffer = locala.ll(((a.f)localObject2).id, 4096);
              f3 = ((a.f)localObject2).MIG;
              f2 = ((a.f)localObject2).MIH;
              f1 = f3;
              if (Float.isInfinite(((a.f)localObject2).MIH))
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
              if (!Float.isInfinite(((a.f)localObject2).MII)) {
                break label889;
              }
              f3 = f2 + 100000.0F;
              f2 = f1;
              if (f1 < -70000.0F) {
                f2 = -70000.0F;
              }
              f2 += 100000.0F;
              f1 = f3;
              if ((!((a.f)localObject2).b(a.b.MHI)) && (!((a.f)localObject2).b(a.b.MHJ))) {
                break label918;
              }
              paramAnonymousByteBuffer.setScrollY((int)f2);
              paramAnonymousByteBuffer.setMaxScrollY((int)f1);
              if (((a.f)localObject2).MIE <= 0) {
                break label970;
              }
              paramAnonymousByteBuffer.setItemCount(((a.f)localObject2).MIE);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).MIF);
              paramAnonymousArrayOfString = ((a.f)localObject2).MIY.iterator();
              i = 0;
              label847:
              if (!paramAnonymousArrayOfString.hasNext()) {
                break label956;
              }
              if (((a.f)paramAnonymousArrayOfString.next()).a(a.d.MIo)) {
                break label1464;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break label847;
            i = 0;
            break label650;
            label889:
            f2 -= ((a.f)localObject2).MII;
            f3 = f1 - ((a.f)localObject2).MII;
            f1 = f2;
            f2 = f3;
            break label772;
            if ((!((a.f)localObject2).b(a.b.MHG)) && (!((a.f)localObject2).b(a.b.MHH))) {
              break label807;
            }
            paramAnonymousByteBuffer.setScrollX((int)f2);
            paramAnonymousByteBuffer.setMaxScrollX((int)f1);
            break label807;
            label956:
            paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).MIF + i - 1);
            label970:
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            label976:
            if (((a.f)localObject2).a(a.d.MIq))
            {
              if (((((a.f)localObject2).label == null) && (((a.f)localObject2).MIV == null)) || ((((a.f)localObject2).label != null) && (((a.f)localObject2).MIV != null) && (((a.f)localObject2).label.equals(((a.f)localObject2).MIV)))) {
                break label1420;
              }
              i = 1;
              if (i != 0) {
                locala.ajg(((a.f)localObject2).id);
              }
            }
            if ((locala.MHj != null) && (locala.MHj.id == ((a.f)localObject2).id) && (!((a.f)localObject2).b(a.d.MId)) && (((a.f)localObject2).a(a.d.MId)))
            {
              paramAnonymousByteBuffer = locala.ll(((a.f)localObject2).id, 4);
              paramAnonymousByteBuffer.getText().add(((a.f)localObject2).label);
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            }
            if ((locala.MHn != null) && (locala.MHn.id == ((a.f)localObject2).id) && ((locala.MHo == null) || (locala.MHo.id != locala.MHn.id)))
            {
              locala.MHo = locala.MHn;
              locala.sendAccessibilityEvent(locala.ll(((a.f)localObject2).id, 8));
              if ((locala.MHn == null) || (locala.MHn.id != ((a.f)localObject2).id) || (!((a.f)localObject2).b(a.d.MIf)) || (!((a.f)localObject2).a(a.d.MIf)) || ((locala.MHj != null) && (locala.MHj.id != locala.MHn.id))) {
                break label1441;
              }
              if (((a.f)localObject2).MIU == null) {
                break label1443;
              }
              paramAnonymousByteBuffer = ((a.f)localObject2).MIU;
              if (((a.f)localObject2).value == null) {
                break label1450;
              }
            }
            for (paramAnonymousArrayOfString = ((a.f)localObject2).value;; paramAnonymousArrayOfString = "")
            {
              paramAnonymousByteBuffer = locala.ab(((a.f)localObject2).id, paramAnonymousByteBuffer, paramAnonymousArrayOfString);
              if (paramAnonymousByteBuffer != null) {
                locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              }
              if ((((a.f)localObject2).MIP == ((a.f)localObject2).MIB) && (((a.f)localObject2).MIQ == ((a.f)localObject2).MIC)) {
                break;
              }
              paramAnonymousByteBuffer = locala.ll(((a.f)localObject2).id, 8192);
              paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).MIB);
              paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).MIC);
              paramAnonymousByteBuffer.setItemCount(paramAnonymousArrayOfString.length());
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              break;
              i = 0;
              break label1038;
              if (locala.MHn != null) {
                break label1210;
              }
              locala.MHo = null;
              break label1210;
              break;
              paramAnonymousByteBuffer = "";
              break label1297;
            }
            AppMethodBeat.o(9693);
            return;
          }
        }
      }
    };
    this.MHu = new AccessibilityManager.AccessibilityStateChangeListener()
    {
      public final void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9797);
        if (paramAnonymousBoolean)
        {
          a.e(a.this).a(a.d(a.this));
          a.e(a.this).MCg.setSemanticsEnabled(true);
        }
        for (;;)
        {
          if (a.f(a.this) != null) {
            a.f(a.this).bd(paramAnonymousBoolean, a.g(a.this).isTouchExplorationEnabled());
          }
          AppMethodBeat.o(9797);
          return;
          a.e(a.this).a(null);
          a.e(a.this).MCg.setSemanticsEnabled(false);
        }
      }
    };
    this.MHw = new ContentObserver(new Handler())
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
          a.a(a.this, a.i(a.this) | a.a.MHC.value);
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
          a.a(a.this, a.i(a.this) & (a.a.MHC.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.rootAccessibilityView = paramView;
    this.MCj = parama;
    this.nA = paramAccessibilityManager;
    this.aFz = paramContentResolver;
    this.MHg = paramg;
    this.MHu.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.nA.addAccessibilityStateChangeListener(this.MHu);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.MHv = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (paramAnonymousBoolean) {
            a.a(a.this, a.i(a.this) | a.a.MHA.value);
          }
          for (;;)
          {
            a.j(a.this);
            if (a.f(a.this) != null) {
              a.f(a.this).bd(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            a.k(a.this);
            a.a(a.this, a.i(a.this) & (a.a.MHA.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.MHv.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.nA.addTouchExplorationStateChangeListener(this.MHv);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.MHw.onChange(false);
        parama = Settings.Global.getUriFor("transition_animation_scale");
        this.aFz.registerContentObserver(parama, false, this.MHw);
      }
      if (paramg != null) {
        paramg.a(this);
      }
      this.MHf = new AccessibilityViewEmbedder(paramView, 65536);
      AppMethodBeat.o(9750);
      return;
      this.MHv = null;
    }
  }
  
  private boolean a(final f paramf)
  {
    AppMethodBeat.i(9752);
    if ((paramf.MIE > 0) && ((f.a(this.MHj, new c() {})) || (!f.a(this.MHj, new c() {}))))
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
        if ((paramBoolean) && (paramf.a(b.MHN)))
        {
          this.MCj.dispatchSemanticsAction(paramInt, b.MHN, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!paramf.a(b.MHO)));
      this.MCj.dispatchSemanticsAction(paramInt, b.MHO, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (paramf.a(b.MHX)))
      {
        this.MCj.dispatchSemanticsAction(paramInt, b.MHX, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!paramf.a(b.MHY)));
    this.MCj.dispatchSemanticsAction(paramInt, b.MHY, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void au(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.MHh.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    f localf = gfq().r(new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localf != this.MHp)
    {
      if (localf != null) {
        lk(localf.id, 128);
      }
      if (this.MHp != null) {
        lk(this.MHp.id, 256);
      }
      this.MHp = localf;
    }
    AppMethodBeat.o(9762);
  }
  
  private void gfr()
  {
    AppMethodBeat.i(9761);
    if (this.MHp != null)
    {
      lk(this.MHp.id, 256);
      this.MHp = null;
    }
    AppMethodBeat.o(9761);
  }
  
  final AccessibilityEvent ab(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = ll(paramInt, 16);
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
  
  final f aje(int paramInt)
  {
    AppMethodBeat.i(9758);
    f localf2 = (f)this.MHh.get(Integer.valueOf(paramInt));
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f(this);
      localf1.id = paramInt;
      this.MHh.put(Integer.valueOf(paramInt), localf1);
    }
    AppMethodBeat.o(9758);
    return localf1;
  }
  
  final c ajf(int paramInt)
  {
    AppMethodBeat.i(9759);
    c localc2 = (c)this.MHi.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      localc1.id = paramInt;
      localc1.resourceId = (MHe + paramInt);
      this.MHi.put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(9759);
    return localc1;
  }
  
  final void ajg(int paramInt)
  {
    AppMethodBeat.i(213239);
    AccessibilityEvent localAccessibilityEvent = ll(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    sendAccessibilityEvent(localAccessibilityEvent);
    AppMethodBeat.o(213239);
  }
  
  public final boolean ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.nA.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    if (this.MHh.isEmpty())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    f localf = gfq().r(new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if (localf.MID != -1)
    {
      boolean bool = this.MHf.onAccessibilityHoverEvent(localf.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      au(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      gfr();
    }
    new StringBuilder("unexpected accessibility hover event: ").append(paramMotionEvent);
    AppMethodBeat.o(9760);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9753);
    if (paramInt >= 65536)
    {
      localObject1 = this.MHf.createAccessibilityNodeInfo(paramInt);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.MHh.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject1 = (f)this.MHh.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject3;
    if (((f)localObject1).MID != -1)
    {
      localObject2 = this.MHg.p(Integer.valueOf(((f)localObject1).MID));
      localObject3 = ((f)localObject1).MJg;
      localObject1 = this.MHf.getRootNode((View)localObject2, ((f)localObject1).id, (Rect)localObject3);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    if (Build.VERSION.SDK_INT >= 18) {
      ((AccessibilityNodeInfo)localObject2).setViewIdResourceName("");
    }
    ((AccessibilityNodeInfo)localObject2).setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    ((AccessibilityNodeInfo)localObject2).setClassName("android.view.View");
    ((AccessibilityNodeInfo)localObject2).setSource(this.rootAccessibilityView, paramInt);
    boolean bool1;
    if (!((f)localObject1).a(d.MIm)) {
      if (((f)localObject1).a(d.MIv))
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setFocusable(bool1);
        if (this.MHn != null)
        {
          if (this.MHn.id != paramInt) {
            break label1625;
          }
          bool1 = true;
          label297:
          ((AccessibilityNodeInfo)localObject2).setFocused(bool1);
        }
        if (this.MHj != null)
        {
          if (this.MHj.id != paramInt) {
            break label1631;
          }
          bool1 = true;
          label325:
          ((AccessibilityNodeInfo)localObject2).setAccessibilityFocused(bool1);
        }
        if (((f)localObject1).a(d.MIf))
        {
          ((AccessibilityNodeInfo)localObject2).setPassword(((f)localObject1).a(d.MIl));
          if (!((f)localObject1).a(d.MIu)) {
            ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.EditText");
          }
          if (Build.VERSION.SDK_INT >= 18)
          {
            if (((f)localObject1).a(d.MIu)) {
              break label1637;
            }
            bool1 = true;
            label397:
            ((AccessibilityNodeInfo)localObject2).setEditable(bool1);
            if ((((f)localObject1).MIB != -1) && (((f)localObject1).MIC != -1)) {
              ((AccessibilityNodeInfo)localObject2).setTextSelection(((f)localObject1).MIB, ((f)localObject1).MIC);
            }
            if ((Build.VERSION.SDK_INT > 18) && (this.MHj != null) && (this.MHj.id == paramInt)) {
              ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
            }
          }
          if (!((f)localObject1).a(b.MHN)) {
            break label1927;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(256);
        }
      }
    }
    label899:
    label1927:
    for (int j = 1;; j = 0)
    {
      if (((f)localObject1).a(b.MHO))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = 1;
      }
      int i = j;
      if (((f)localObject1).a(b.MHX))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (((f)localObject1).a(b.MHY))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = i | 0x2;
      }
      ((AccessibilityNodeInfo)localObject2).setMovementGranularities(j);
      label593:
      Object localObject4;
      label801:
      label861:
      label1016:
      boolean bool4;
      if ((Build.VERSION.SDK_INT >= 21) && (((f)localObject1).MIz >= 0))
      {
        if (((f)localObject1).value == null)
        {
          i = 0;
          ((AccessibilityNodeInfo)localObject2).setMaxTextLength(i - ((f)localObject1).MIA + ((f)localObject1).MIz);
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          if (((f)localObject1).a(b.MHP)) {
            ((AccessibilityNodeInfo)localObject2).addAction(131072);
          }
          if (((f)localObject1).a(b.MHQ)) {
            ((AccessibilityNodeInfo)localObject2).addAction(16384);
          }
          if (((f)localObject1).a(b.MHR)) {
            ((AccessibilityNodeInfo)localObject2).addAction(65536);
          }
          if (((f)localObject1).a(b.MHS)) {
            ((AccessibilityNodeInfo)localObject2).addAction(32768);
          }
        }
        if ((((f)localObject1).a(d.MIe)) || (((f)localObject1).a(d.MIw))) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Button");
        }
        if (((f)localObject1).a(d.MIp)) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ImageView");
        }
        if ((Build.VERSION.SDK_INT > 18) && (((f)localObject1).a(b.MHW)))
        {
          ((AccessibilityNodeInfo)localObject2).setDismissable(true);
          ((AccessibilityNodeInfo)localObject2).addAction(1048576);
        }
        if (((f)localObject1).MIW == null) {
          break label1655;
        }
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView, ((f)localObject1).MIW.id);
        localObject3 = ((f)localObject1).MJg;
        if (((f)localObject1).MIW == null) {
          break label1667;
        }
        localObject4 = ((f)localObject1).MIW.MJg;
        Rect localRect = new Rect((Rect)localObject3);
        localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent(localRect);
        ((AccessibilityNodeInfo)localObject2).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject2).setVisibleToUser(true);
        if ((((f)localObject1).a(d.MIh)) && (!((f)localObject1).a(d.MIi))) {
          break label1677;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setEnabled(bool1);
        if (((f)localObject1).a(b.MHE))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).MJa == null)) {
            break label1683;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, ((f)localObject1).MJa.hint));
          ((AccessibilityNodeInfo)localObject2).setClickable(true);
        }
        label961:
        if (((f)localObject1).a(b.MHF))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).MJb == null)) {
            break label1699;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, ((f)localObject1).MJb.hint));
          ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        }
        if ((((f)localObject1).a(b.MHG)) || (((f)localObject1).a(b.MHI)) || (((f)localObject1).a(b.MHH)) || (((f)localObject1).a(b.MHJ)))
        {
          ((AccessibilityNodeInfo)localObject2).setScrollable(true);
          if (((f)localObject1).a(d.MIt))
          {
            if ((!((f)localObject1).a(b.MHG)) && (!((f)localObject1).a(b.MHH))) {
              break label1726;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!a((f)localObject1))) {
              break label1715;
            }
            ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((f)localObject1).MIE, false));
          }
          label1131:
          if ((((f)localObject1).a(b.MHG)) || (((f)localObject1).a(b.MHI))) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if ((((f)localObject1).a(b.MHH)) || (((f)localObject1).a(b.MHJ))) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(b.MHK)) || (((f)localObject1).a(b.MHL)))
        {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.SeekBar");
          if (((f)localObject1).a(b.MHK)) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if (((f)localObject1).a(b.MHL)) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(d.MIq)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
        }
        boolean bool3 = ((f)localObject1).a(d.MIb);
        bool4 = ((f)localObject1).a(d.MIr);
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
          break label1783;
        }
        ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.MIc));
        ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
        if (!((f)localObject1).a(d.MIj)) {
          break label1772;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.RadioButton");
        label1375:
        ((AccessibilityNodeInfo)localObject2).setSelected(((f)localObject1).a(d.MId));
        if (Build.VERSION.SDK_INT >= 28) {
          ((AccessibilityNodeInfo)localObject2).setHeading(((f)localObject1).a(d.MIk));
        }
        if ((this.MHj == null) || (this.MHj.id != paramInt)) {
          break label1846;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).MIZ == null)) {
          break label1856;
        }
        localObject3 = ((f)localObject1).MIZ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(((c)localObject4).resourceId, ((c)localObject4).label));
        }
        if (((((b.MHH.value | b.MHG.value | b.MHI.value | b.MHJ.value) ^ 0xFFFFFFFF) & ((f)localObject1).MIy) != 0) || (((f)localObject1).flags != 0) || ((((f)localObject1).label != null) && (!((f)localObject1).label.isEmpty())) || ((((f)localObject1).value != null) && (!((f)localObject1).value.isEmpty())) || ((((f)localObject1).hint != null) && (!((f)localObject1).hint.isEmpty())))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        label1625:
        bool1 = false;
        break label297;
        label1631:
        bool1 = false;
        break label325;
        label1637:
        bool1 = false;
        break label397;
        i = ((f)localObject1).value.length();
        break label593;
        label1655:
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView);
        break label801;
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent((Rect)localObject3);
        break label861;
        label1677:
        bool1 = false;
        break label899;
        label1683:
        ((AccessibilityNodeInfo)localObject2).addAction(16);
        ((AccessibilityNodeInfo)localObject2).setClickable(true);
        break label961;
        label1699:
        ((AccessibilityNodeInfo)localObject2).addAction(32);
        ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        break label1016;
        label1715:
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.HorizontalScrollView");
        break label1131;
        label1726:
        if ((Build.VERSION.SDK_INT > 18) && (a((f)localObject1)))
        {
          ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((f)localObject1).MIE, 0, false));
          break label1131;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ScrollView");
        break label1131;
        label1772:
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.CheckBox");
        break label1375;
        label1783:
        if (bool4)
        {
          ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.MIs));
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Switch");
          ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
          break label1375;
        }
        if (((f)localObject1).a(d.MIm)) {
          break label1375;
        }
        ((AccessibilityNodeInfo)localObject2).setText(f.b((f)localObject1));
        break label1375;
        label1846:
        ((AccessibilityNodeInfo)localObject2).addAction(64);
      }
      label1856:
      localObject1 = ((f)localObject1).MIX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        if (!((f)localObject3).a(d.MIo)) {
          ((AccessibilityNodeInfo)localObject2).addChild(this.rootAccessibilityView, ((f)localObject3).id);
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
      if (this.MHn != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.MHn.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.MHl != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.MHl.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.MHj != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.MHj.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.MHk == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.MHk.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  final f gfq()
  {
    AppMethodBeat.i(9757);
    f localf = (f)this.MHh.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localf;
  }
  
  final void lk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.nA.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    sendAccessibilityEvent(ll(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  final AccessibilityEvent ll(int paramInt1, int paramInt2)
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
      bool = this.MHf.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.MHk = null;
      }
      AppMethodBeat.o(9754);
      return bool;
    }
    f localf = (f)this.MHh.get(Integer.valueOf(paramInt1));
    if (localf == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = MHe;
      paramBundle = (c)this.MHi.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.MCj.dispatchSemanticsAction(paramInt1, b.MHV, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHE);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHF);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (localf.a(b.MHI)) {
        this.MCj.dispatchSemanticsAction(paramInt1, b.MHI);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.MHG))
        {
          this.MCj.dispatchSemanticsAction(paramInt1, b.MHG);
        }
        else
        {
          if (!localf.a(b.MHK)) {
            break;
          }
          localf.value = localf.MIJ;
          lk(paramInt1, 4);
          this.MCj.dispatchSemanticsAction(paramInt1, b.MHK);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (localf.a(b.MHJ)) {
        this.MCj.dispatchSemanticsAction(paramInt1, b.MHJ);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.MHH))
        {
          this.MCj.dispatchSemanticsAction(paramInt1, b.MHH);
        }
        else
        {
          if (!localf.a(b.MHL)) {
            break;
          }
          localf.value = localf.MIK;
          lk(paramInt1, 4);
          this.MCj.dispatchSemanticsAction(paramInt1, b.MHL);
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
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHU);
      lk(paramInt1, 65536);
      this.MHj = null;
      this.MHk = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHT);
      lk(paramInt1, 32768);
      if (this.MHj == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.MHj = localf;
      if ((localf.a(b.MHK)) || (localf.a(b.MHL))) {
        lk(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHM);
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
        this.MCj.dispatchSemanticsAction(paramInt1, b.MHP, localHashMap);
        AppMethodBeat.o(9754);
        return true;
        localHashMap.put("base", Integer.valueOf(localf.MIC));
        localHashMap.put("extent", Integer.valueOf(localf.MIC));
      }
    case 16384: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHQ);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHR);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHS);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.MCj.dispatchSemanticsAction(paramInt1, b.MHW);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(9751);
    if (this.MHg != null) {
      this.MHg.gfl();
    }
    this.MBS = null;
    this.nA.removeAccessibilityStateChangeListener(this.MHu);
    if (Build.VERSION.SDK_INT >= 19) {
      this.nA.removeTouchExplorationStateChangeListener(this.MHv);
    }
    this.aFz.unregisterContentObserver(this.MHw);
    AppMethodBeat.o(9751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(9767);
    this.MHh.clear();
    if (this.MHj != null) {
      lk(this.MHj.id, 65536);
    }
    this.MHj = null;
    this.MHp = null;
    ajg(0);
    AppMethodBeat.o(9767);
  }
  
  final void sendAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.nA.isEnabled())
    {
      AppMethodBeat.o(9765);
      return;
    }
    this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, paramAccessibilityEvent);
    AppMethodBeat.o(9765);
  }
  
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(9783);
      MHE = new b("TAP", 0, 1);
      MHF = new b("LONG_PRESS", 1, 2);
      MHG = new b("SCROLL_LEFT", 2, 4);
      MHH = new b("SCROLL_RIGHT", 3, 8);
      MHI = new b("SCROLL_UP", 4, 16);
      MHJ = new b("SCROLL_DOWN", 5, 32);
      MHK = new b("INCREASE", 6, 64);
      MHL = new b("DECREASE", 7, 128);
      MHM = new b("SHOW_ON_SCREEN", 8, 256);
      MHN = new b("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      MHO = new b("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      MHP = new b("SET_SELECTION", 11, 2048);
      MHQ = new b("COPY", 12, 4096);
      MHR = new b("CUT", 13, 8192);
      MHS = new b("PASTE", 14, 16384);
      MHT = new b("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      MHU = new b("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      MHV = new b("CUSTOM_ACTION", 17, 131072);
      MHW = new b("DISMISS", 18, 262144);
      MHX = new b("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      MHY = new b("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      MHZ = new b[] { MHE, MHF, MHG, MHH, MHI, MHJ, MHK, MHL, MHM, MHN, MHO, MHP, MHQ, MHR, MHS, MHT, MHU, MHV, MHW, MHX, MHY };
      AppMethodBeat.o(9783);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class c
  {
    int MIa = -1;
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
      MIb = new d("HAS_CHECKED_STATE", 0, 1);
      MIc = new d("IS_CHECKED", 1, 2);
      MId = new d("IS_SELECTED", 2, 4);
      MIe = new d("IS_BUTTON", 3, 8);
      MIf = new d("IS_TEXT_FIELD", 4, 16);
      MIg = new d("IS_FOCUSED", 5, 32);
      MIh = new d("HAS_ENABLED_STATE", 6, 64);
      MIi = new d("IS_ENABLED", 7, 128);
      MIj = new d("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      MIk = new d("IS_HEADER", 9, 512);
      MIl = new d("IS_OBSCURED", 10, 1024);
      MIm = new d("SCOPES_ROUTE", 11, 2048);
      MIn = new d("NAMES_ROUTE", 12, 4096);
      MIo = new d("IS_HIDDEN", 13, 8192);
      MIp = new d("IS_IMAGE", 14, 16384);
      MIq = new d("IS_LIVE_REGION", 15, 32768);
      MIr = new d("HAS_TOGGLED_STATE", 16, 65536);
      MIs = new d("IS_TOGGLED", 17, 131072);
      MIt = new d("HAS_IMPLICIT_SCROLLING", 18, 262144);
      MIu = new d("IS_READ_ONLY", 19, 1048576);
      MIv = new d("IS_FOCUSABLE", 20, 2097152);
      MIw = new d("IS_LINK", 21, 4194304);
      MIx = new d[] { MIb, MIc, MId, MIe, MIf, MIg, MIh, MIi, MIj, MIk, MIl, MIm, MIn, MIo, MIp, MIq, MIr, MIs, MIt, MIu, MIv, MIw };
      AppMethodBeat.o(9679);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface e
  {
    public abstract void bd(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  static final class f
  {
    final a MBQ;
    int MIA;
    int MIB;
    int MIC;
    int MID;
    int MIE;
    int MIF;
    float MIG;
    float MIH;
    float MII;
    String MIJ;
    String MIK;
    private a.g MIL;
    boolean MIM;
    private int MIN;
    private int MIO;
    int MIP;
    int MIQ;
    float MIR;
    private float MIS;
    private float MIT;
    String MIU;
    String MIV;
    f MIW;
    List<f> MIX;
    List<f> MIY;
    List<a.c> MIZ;
    int MIy;
    int MIz;
    a.c MJa;
    a.c MJb;
    boolean MJc;
    private float[] MJd;
    boolean MJe;
    private float[] MJf;
    Rect MJg;
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
      this.MIM = false;
      this.MIX = new ArrayList();
      this.MIY = new ArrayList();
      this.MJc = true;
      this.MJe = true;
      this.MBQ = parama;
      AppMethodBeat.o(9803);
    }
    
    static boolean a(f paramf, c<f> paramc)
    {
      AppMethodBeat.i(9802);
      if (paramf != null)
      {
        paramf = paramf.MIW;
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
          paramf = paramf.MIW;
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
    
    private String gft()
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
    
    private static float q(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    final void a(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.MIM = true;
      this.MIU = this.value;
      this.MIV = this.label;
      this.MIN = this.flags;
      this.MIO = this.MIy;
      this.MIP = this.MIB;
      this.MIQ = this.MIC;
      this.MIR = this.MIG;
      this.MIS = this.MIH;
      this.MIT = this.MII;
      this.flags = paramByteBuffer.getInt();
      this.MIy = paramByteBuffer.getInt();
      this.MIz = paramByteBuffer.getInt();
      this.MIA = paramByteBuffer.getInt();
      this.MIB = paramByteBuffer.getInt();
      this.MIC = paramByteBuffer.getInt();
      this.MID = paramByteBuffer.getInt();
      this.MIE = paramByteBuffer.getInt();
      this.MIF = paramByteBuffer.getInt();
      this.MIG = paramByteBuffer.getFloat();
      this.MIH = paramByteBuffer.getFloat();
      this.MII = paramByteBuffer.getFloat();
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
        this.MIJ = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label379;
        }
        str = null;
        label249:
        this.MIK = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label387;
        }
      }
      label387:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.MIL = a.g.ajh(paramByteBuffer.getInt());
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
      this.MJc = true;
      this.MJe = true;
      int j = paramByteBuffer.getInt();
      this.MIX.clear();
      this.MIY.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.MBQ, paramByteBuffer.getInt());
        paramArrayOfString.MIW = this;
        this.MIX.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.MBQ, paramByteBuffer.getInt());
        paramArrayOfString.MIW = this;
        this.MIY.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.MIZ = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.MIZ == null)
      {
        this.MIZ = new ArrayList(j);
        i = 0;
        label559:
        if (i >= j) {
          break label660;
        }
        paramArrayOfString = a.c(this.MBQ, paramByteBuffer.getInt());
        if (paramArrayOfString.MIa != a.b.MHE.value) {
          break label625;
        }
        this.MJa = paramArrayOfString;
      }
      for (;;)
      {
        this.MIZ.add(paramArrayOfString);
        i += 1;
        break label559;
        this.MIZ.clear();
        break;
        label625:
        if (paramArrayOfString.MIa == a.b.MHF.value) {
          this.MJb = paramArrayOfString;
        } else {
          this.MIZ.add(paramArrayOfString);
        }
      }
      label660:
      AppMethodBeat.o(9804);
    }
    
    final void a(float[] paramArrayOfFloat, Set<f> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.MJe) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.MJf == null) {
          this.MJf = new float[16];
        }
        Matrix.multiplyMM(this.MJf, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat1, this.MJf, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat2, this.MJf, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat3, this.MJf, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat4, this.MJf, paramArrayOfFloat);
        if (this.MJg == null) {
          this.MJg = new Rect();
        }
        this.MJg.set(Math.round(q(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(q(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(d(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(d(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.MJe = false;
      }
      paramArrayOfFloat = this.MIX.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((f)paramArrayOfFloat.next()).a(this.MJf, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    final boolean a(a.b paramb)
    {
      return (this.MIy & paramb.value) != 0;
    }
    
    final boolean a(a.d paramd)
    {
      return (this.flags & paramd.value) != 0;
    }
    
    final boolean b(a.b paramb)
    {
      return (this.MIO & paramb.value) != 0;
    }
    
    final boolean b(a.d paramd)
    {
      return (this.MIN & paramd.value) != 0;
    }
    
    final String gfs()
    {
      AppMethodBeat.i(9807);
      if ((a(a.d.MIn)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.MIX.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((f)((Iterator)localObject).next()).gfs();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    final void iZ(List<f> paramList)
    {
      AppMethodBeat.i(9806);
      if (a(a.d.MIm)) {
        paramList.add(this);
      }
      Iterator localIterator = this.MIX.iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).iZ(paramList);
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
      Iterator localIterator = this.MIY.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.a(a.d.MIo))
        {
          if (localf.MJc)
          {
            localf.MJc = false;
            if (localf.MJd == null) {
              localf.MJd = new float[16];
            }
            if (!Matrix.invertM(localf.MJd, 0, localf.transform, 0)) {
              Arrays.fill(localf.MJd, 0.0F);
            }
          }
          Matrix.multiplyMV(arrayOfFloat, 0, localf.MJd, 0, paramArrayOfFloat, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.a
 * JD-Core Version:    0.7.0.1
 */