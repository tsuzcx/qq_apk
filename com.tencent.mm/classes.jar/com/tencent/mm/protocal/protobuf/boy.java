package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class boy
  extends com.tencent.mm.bx.a
{
  public float ZXq;
  public float ZXr;
  public float ZXs;
  public float ZXt;
  public float ZXu;
  public boolean ZXv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258144);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.ZXq);
      paramVarArgs.l(2, this.ZXr);
      paramVarArgs.l(3, this.ZXs);
      paramVarArgs.l(4, this.ZXt);
      paramVarArgs.l(5, this.ZXu);
      paramVarArgs.di(6, this.ZXv);
      AppMethodBeat.o(258144);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(258144);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + (m + 4) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258144);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      boy localboy = (boy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258144);
        return -1;
      case 1: 
        localboy.ZXq = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258144);
        return 0;
      case 2: 
        localboy.ZXr = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258144);
        return 0;
      case 3: 
        localboy.ZXs = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258144);
        return 0;
      case 4: 
        localboy.ZXt = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258144);
        return 0;
      case 5: 
        localboy.ZXu = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(258144);
        return 0;
      }
      localboy.ZXv = locala.ajGk.aai();
      AppMethodBeat.o(258144);
      return 0;
    }
    AppMethodBeat.o(258144);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boy
 * JD-Core Version:    0.7.0.1
 */