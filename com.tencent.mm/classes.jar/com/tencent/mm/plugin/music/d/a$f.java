package com.tencent.mm.plugin.music.d;

import com.tencent.mm.sdk.platformtools.y;

final class a$f
{
  int[] myQ = { 1, 1, 1, 1 };
  
  static int t(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = -268435456;; i = 0) {
      return i | paramInt;
    }
  }
  
  final boolean b(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 268435455;
      int k = this.myQ.length - paramArrayOfInt.length;
      j = k;
      paramBoolean = true;
      label23:
      if (j >= this.myQ.length) {
        return paramBoolean;
      }
      if ((this.myQ[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      paramBoolean &= bool;
      j += 1;
      break label23;
      i = -1;
      break;
    }
    return paramBoolean;
  }
  
  final void s(boolean paramBoolean, int paramInt)
  {
    int i = t(paramBoolean, paramInt);
    y.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.myQ[3] + ",newState=" + i);
    if (this.myQ[3] == i) {
      return;
    }
    this.myQ[0] = this.myQ[1];
    this.myQ[1] = this.myQ[2];
    this.myQ[2] = this.myQ[3];
    this.myQ[3] = i;
    y.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.myQ[0] + "," + this.myQ[1] + "," + this.myQ[2] + "," + this.myQ[3] + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.f
 * JD-Core Version:    0.7.0.1
 */