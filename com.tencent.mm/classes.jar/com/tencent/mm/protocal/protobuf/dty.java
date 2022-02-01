package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dty
  extends com.tencent.mm.bx.a
{
  public String Fvh;
  public String GaD;
  public String HGV;
  public String jdh;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.HGV == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.HGV != null) {
        paramVarArgs.d(2, this.HGV);
      }
      if (this.nEt != null) {
        paramVarArgs.d(3, this.nEt);
      }
      if (this.GaD != null) {
        paramVarArgs.d(4, this.GaD);
      }
      if (this.jdh != null) {
        paramVarArgs.d(5, this.jdh);
      }
      if (this.Fvh != null) {
        paramVarArgs.d(6, this.Fvh);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HGV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HGV);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nEt);
      }
      paramInt = i;
      if (this.GaD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GaD);
      }
      i = paramInt;
      if (this.jdh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdh);
      }
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvh);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nDo == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.HGV == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dty localdty = (dty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localdty.nDo = locala.NPN.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localdty.HGV = locala.NPN.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localdty.nEt = locala.NPN.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localdty.GaD = locala.NPN.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localdty.jdh = locala.NPN.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localdty.Fvh = locala.NPN.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dty
 * JD-Core Version:    0.7.0.1
 */