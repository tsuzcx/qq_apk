package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public final class c
{
  public static final c oA;
  public static final c oB;
  public static final c oC;
  public static final c oD;
  public static final c oE;
  public static final c oF;
  public static final c oG;
  public static final c oH;
  public static final c oI;
  public static final c oJ;
  public static final c oK;
  public static final c oL;
  public static final c oM;
  public static final c oN;
  public static final c oO;
  public static final c oP;
  public static final c oQ;
  public static final c oR;
  public static final c oo;
  public static final c op;
  public static final c oq;
  public static final c or;
  public static final c os;
  public static final c ot;
  public static final c ou;
  public static final c ov;
  public static final c ow;
  public static final c ox;
  public static final c oy;
  public static final c oz;
  final Object oS;
  
  static
  {
    Object localObject2 = null;
    oo = new c(1);
    op = new c(2);
    oq = new c(4);
    or = new c(8);
    os = new c(16);
    ot = new c(32);
    ou = new c(64);
    ov = new c(128);
    ow = new c(256);
    ox = new c(512);
    oy = new c(1024);
    oz = new c(2048);
    oA = new c(4096);
    oB = new c(8192);
    oC = new c(16384);
    oD = new c(32768);
    oE = new c(65536);
    oF = new c(131072);
    oG = new c(262144);
    oH = new c(524288);
    oI = new c(1048576);
    oJ = new c(2097152);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
      oK = new c(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label463;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
      label306:
      oL = new c(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label468;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
      label329:
      oM = new c(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label473;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
      label352:
      oN = new c(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label478;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
      label375:
      oO = new c(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label483;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
      label398:
      oP = new c(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label488;
      }
    }
    label463:
    label468:
    label473:
    label478:
    label483:
    label488:
    for (Object localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;; localObject1 = null)
    {
      oQ = new c(localObject1);
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      }
      oR = new c(localObject1);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label306;
      localObject1 = null;
      break label329;
      localObject1 = null;
      break label352;
      localObject1 = null;
      break label375;
      localObject1 = null;
      break label398;
    }
  }
  
  private c(int paramInt) {}
  
  private c(Object paramObject)
  {
    this.oS = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.c
 * JD-Core Version:    0.7.0.1
 */