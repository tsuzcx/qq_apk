package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;

public class TransitionFilter
  implements ITransitionFilter
{
  private TransitionAlphaFilter mAlphaFilter;
  private TransitionBlendFilter mBlendFilter;
  private ITransitionFilter mCurrFilter;
  private TransitionMoveFilter mMoveFilter;
  
  public TransitionFilter()
  {
    AppMethodBeat.i(83055);
    this.mBlendFilter = new TransitionBlendFilter();
    this.mAlphaFilter = new TransitionAlphaFilter();
    this.mMoveFilter = new TransitionMoveFilter();
    AppMethodBeat.o(83055);
  }
  
  public void ApplyGLSLFilter(String paramString)
  {
    AppMethodBeat.i(83060);
    this.mBlendFilter.ApplyGLSLFilter();
    this.mAlphaFilter.ApplyGLSLFilter();
    this.mMoveFilter.ApplyGLSLFilter();
    setDataPath(paramString);
    AppMethodBeat.o(83060);
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(83064);
    this.mBlendFilter.ClearGLSL();
    this.mAlphaFilter.ClearGLSL();
    this.mMoveFilter.ClearGLSL();
    AppMethodBeat.o(83064);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    AppMethodBeat.i(83061);
    if (this.mCurrFilter != null) {
      this.mCurrFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramh);
    }
    AppMethodBeat.o(83061);
  }
  
  public boolean needRender()
  {
    return this.mCurrFilter != null;
  }
  
  public void reset()
  {
    AppMethodBeat.i(83062);
    this.mBlendFilter.reset();
    this.mAlphaFilter.reset();
    this.mMoveFilter.reset();
    AppMethodBeat.o(83062);
  }
  
  public void setDataPath(String paramString)
  {
    AppMethodBeat.i(83057);
    this.mBlendFilter.setDataPath(paramString);
    this.mMoveFilter.setDataPath(paramString);
    this.mAlphaFilter.setDataPath(paramString);
    AppMethodBeat.o(83057);
  }
  
  public void setLastTex(int paramInt)
  {
    AppMethodBeat.i(83058);
    if (this.mCurrFilter != null) {
      this.mCurrFilter.setLastTex(paramInt);
    }
    AppMethodBeat.o(83058);
  }
  
  public void setMvPart(FabbyMvPart paramFabbyMvPart)
  {
    AppMethodBeat.i(83056);
    switch (paramFabbyMvPart.transitionFunction)
    {
    default: 
      this.mCurrFilter = null;
      AppMethodBeat.o(83056);
      return;
    case 0: 
      if ((paramFabbyMvPart.transitionItem != null) && (!paramFabbyMvPart.transitionItem.id.isEmpty()))
      {
        this.mBlendFilter.setItem(paramFabbyMvPart.transitionItem);
        this.mBlendFilter.setDuration(paramFabbyMvPart.transitionDuration);
        this.mBlendFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
        this.mBlendFilter.setMaskType(paramFabbyMvPart.transitionMaskType);
        this.mCurrFilter = this.mBlendFilter;
        AppMethodBeat.o(83056);
        return;
      }
      this.mCurrFilter = null;
      AppMethodBeat.o(83056);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      this.mMoveFilter.setDuration(paramFabbyMvPart.transitionDuration);
      this.mMoveFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
      this.mMoveFilter.setMoveOrientation(paramFabbyMvPart.transitionFunction);
      this.mCurrFilter = this.mMoveFilter;
      AppMethodBeat.o(83056);
      return;
    }
    this.mAlphaFilter.setDuration(paramFabbyMvPart.transitionDuration);
    this.mAlphaFilter.setEaseCurve(paramFabbyMvPart.transitionEase);
    this.mCurrFilter = this.mAlphaFilter;
    AppMethodBeat.o(83056);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(83063);
    this.mBlendFilter.setRenderMode(paramInt);
    this.mAlphaFilter.setRenderMode(paramInt);
    this.mMoveFilter.setRenderMode(paramInt);
    AppMethodBeat.o(83063);
  }
  
  public void updatePreview(long paramLong)
  {
    AppMethodBeat.i(83059);
    if (this.mCurrFilter != null) {
      this.mCurrFilter.updatePreview(paramLong);
    }
    AppMethodBeat.o(83059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionFilter
 * JD-Core Version:    0.7.0.1
 */