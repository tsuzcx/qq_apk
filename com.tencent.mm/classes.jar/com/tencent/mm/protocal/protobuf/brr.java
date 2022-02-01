package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class brr
  extends com.tencent.mm.bx.a
{
  public String EMd;
  public int ZZS;
  public b ZZT;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260169);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(2, this.object_nonce_id);
      }
      paramVarArgs.bS(3, this.ZZS);
      if (this.ZZT != null) {
        paramVarArgs.d(4, this.ZZT);
      }
      if (this.EMd != null) {
        paramVarArgs.g(5, this.EMd);
      }
      paramVarArgs.bv(6, this.mMJ);
      AppMethodBeat.o(260169);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.object_id) + 0;
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.object_nonce_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZZS);
      paramInt = i;
      if (this.ZZT != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZZT);
      }
      i = paramInt;
      if (this.EMd != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.EMd);
      }
      paramInt = i.a.a.b.b.a.q(6, this.mMJ);
      AppMethodBeat.o(260169);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260169);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      brr localbrr = (brr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260169);
        return -1;
      case 1: 
        localbrr.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(260169);
        return 0;
      case 2: 
        localbrr.object_nonce_id = locala.ajGk.readString();
        AppMethodBeat.o(260169);
        return 0;
      case 3: 
        localbrr.ZZS = locala.ajGk.aar();
        AppMethodBeat.o(260169);
        return 0;
      case 4: 
        localbrr.ZZT = locala.ajGk.kFX();
        AppMethodBeat.o(260169);
        return 0;
      case 5: 
        localbrr.EMd = locala.ajGk.readString();
        AppMethodBeat.o(260169);
        return 0;
      }
      localbrr.mMJ = locala.ajGk.aaw();
      AppMethodBeat.o(260169);
      return 0;
    }
    AppMethodBeat.o(260169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brr
 * JD-Core Version:    0.7.0.1
 */