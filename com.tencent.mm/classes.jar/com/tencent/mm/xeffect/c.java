package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/InputTexture;", "", "()V", "textureId", "", "width", "height", "isOes", "", "rotate", "(IIIZI)V", "crop", "Landroid/graphics/Rect;", "(IIIZILandroid/graphics/Rect;)V", "animation", "Lcom/tencent/mm/xeffect/InputAnimation;", "getAnimation", "()Lcom/tencent/mm/xeffect/InputAnimation;", "setAnimation", "(Lcom/tencent/mm/xeffect/InputAnimation;)V", "contentCrop", "contentCrop$annotations", "getHeight", "()I", "setHeight", "(I)V", "isMirror", "()Z", "setMirror", "(Z)V", "isNeedPosition", "layoutInfo", "Lcom/tencent/mm/xeffect/LayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/xeffect/LayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/xeffect/LayoutInfo;)V", "getRotate", "setRotate", "getTextureId", "setTextureId", "toLayoutInfo", "getToLayoutInfo", "setToLayoutInfo", "getWidth", "setWidth", "cropTo", "", "ratio", "", "hasContentCrop", "updateNative", "Companion", "renderlib_release"})
public final class c
{
  public static final a YZn;
  public boolean Odt;
  public boolean YZh;
  public final Rect YZi;
  public final Rect YZj;
  public LayoutInfo YZk;
  public LayoutInfo YZl;
  public InputAnimation YZm;
  int fSM;
  public int height;
  public int textureId;
  public int width;
  
  static
  {
    AppMethodBeat.i(195639);
    YZn = new a((byte)0);
    AppMethodBeat.o(195639);
  }
  
  public c()
  {
    AppMethodBeat.i(195634);
    this.YZh = true;
    this.YZi = new Rect();
    this.YZj = new Rect();
    this.YZk = new LayoutInfo();
    this.YZl = new LayoutInfo();
    this.YZm = new InputAnimation();
    AppMethodBeat.o(195634);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(195636);
    this.YZh = true;
    this.YZi = new Rect();
    this.YZj = new Rect();
    this.YZk = new LayoutInfo();
    this.YZl = new LayoutInfo();
    this.YZm = new InputAnimation();
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.Odt = paramBoolean;
    this.fSM = paramInt4;
    AppMethodBeat.o(195636);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/InputTexture$Companion;", "", "()V", "CW_ROTATE_0", "", "CW_ROTATE_180", "CW_ROTATE_270", "CW_ROTATE_90", "renderlib_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.c
 * JD-Core Version:    0.7.0.1
 */