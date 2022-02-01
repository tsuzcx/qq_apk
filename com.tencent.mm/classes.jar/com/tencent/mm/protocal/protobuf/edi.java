package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edi
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b HOX;
  public com.tencent.mm.bx.b HOY;
  public String HOZ;
  public String HPa;
  public String HpQ;
  public int Hxm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HpQ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Hxm);
      if (this.HpQ != null) {
        paramVarArgs.d(2, this.HpQ);
      }
      if (this.HOX != null) {
        paramVarArgs.c(3, this.HOX);
      }
      if (this.HOY != null) {
        paramVarArgs.c(4, this.HOY);
      }
      if (this.HOZ != null) {
        paramVarArgs.d(5, this.HOZ);
      }
      if (this.HPa != null) {
        paramVarArgs.d(6, this.HPa);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hxm) + 0;
      paramInt = i;
      if (this.HpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HpQ);
      }
      i = paramInt;
      if (this.HOX != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HOX);
      }
      paramInt = i;
      if (this.HOY != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HOY);
      }
      i = paramInt;
      if (this.HOZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HOZ);
      }
      paramInt = i;
      if (this.HPa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HPa);
      }
      AppMethodBeat.o(32550);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HpQ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      edi localedi = (edi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localedi.Hxm = locala.NPN.zc();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localedi.HpQ = locala.NPN.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localedi.HOX = locala.NPN.gxI();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localedi.HOY = locala.NPN.gxI();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localedi.HOZ = locala.NPN.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localedi.HPa = locala.NPN.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edi
 * JD-Core Version:    0.7.0.1
 */