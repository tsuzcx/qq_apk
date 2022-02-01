package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/InputTexture;", "", "()V", "textureId", "", "width", "height", "isOes", "", "rotate", "(IIIZI)V", "crop", "Landroid/graphics/Rect;", "(IIIZILandroid/graphics/Rect;)V", "animation", "Lcom/tencent/mm/xeffect/InputAnimation;", "getAnimation", "()Lcom/tencent/mm/xeffect/InputAnimation;", "setAnimation", "(Lcom/tencent/mm/xeffect/InputAnimation;)V", "contentCrop", "contentCrop$annotations", "getHeight", "()I", "setHeight", "(I)V", "isMirror", "()Z", "setMirror", "(Z)V", "isNeedPosition", "layoutInfo", "Lcom/tencent/mm/xeffect/LayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/xeffect/LayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/xeffect/LayoutInfo;)V", "getRotate", "setRotate", "getTextureId", "setTextureId", "toLayoutInfo", "getToLayoutInfo", "setToLayoutInfo", "getWidth", "setWidth", "cropTo", "", "ratio", "", "hasContentCrop", "updateNative", "Companion", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class c
{
  public static final c.a agXy;
  public boolean URt;
  public boolean agXs;
  public final Rect agXt;
  public final Rect agXu;
  public LayoutInfo agXv;
  public LayoutInfo agXw;
  public InputAnimation agXx;
  int hYK;
  public int height;
  public int textureId;
  public int width;
  
  static
  {
    AppMethodBeat.i(234520);
    agXy = new c.a((byte)0);
    AppMethodBeat.o(234520);
  }
  
  public c()
  {
    AppMethodBeat.i(234505);
    this.agXs = true;
    this.agXt = new Rect();
    this.agXu = new Rect();
    this.agXv = new LayoutInfo();
    this.agXw = new LayoutInfo();
    this.agXx = new InputAnimation();
    AppMethodBeat.o(234505);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(234512);
    this.agXs = true;
    this.agXt = new Rect();
    this.agXu = new Rect();
    this.agXv = new LayoutInfo();
    this.agXw = new LayoutInfo();
    this.agXx = new InputAnimation();
    this.textureId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.URt = paramBoolean;
    this.hYK = paramInt4;
    AppMethodBeat.o(234512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.c
 * JD-Core Version:    0.7.0.1
 */