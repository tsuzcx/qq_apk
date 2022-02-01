package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class del
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public int FMu;
  public String FxN;
  public int GDa;
  public int GDf;
  public btn GRt;
  public String GRx;
  public String HbT;
  public int HsO;
  public String HsP;
  public String Md5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      paramVarArgs.aS(2, this.FMu);
      paramVarArgs.aS(3, this.Scene);
      if (this.GRx != null) {
        paramVarArgs.d(4, this.GRx);
      }
      if (this.FxN != null) {
        paramVarArgs.d(5, this.FxN);
      }
      paramVarArgs.aS(6, this.GDa);
      if (this.GRt != null)
      {
        paramVarArgs.lC(7, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HsO);
      if (this.HbT != null) {
        paramVarArgs.d(9, this.HbT);
      }
      paramVarArgs.aS(10, this.GDf);
      if (this.HsP != null) {
        paramVarArgs.d(11, this.HsP);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(12, this.AesKey);
      }
      AppMethodBeat.o(117925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FMu) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GRx);
      }
      i = paramInt;
      if (this.FxN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FxN);
      }
      i += f.a.a.b.b.a.bz(6, this.GDa);
      paramInt = i;
      if (this.GRt != null) {
        paramInt = i + f.a.a.a.lB(7, this.GRt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HsO);
      paramInt = i;
      if (this.HbT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HbT);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.GDf);
      paramInt = i;
      if (this.HsP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HsP);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.AesKey);
      }
      AppMethodBeat.o(117925);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        del localdel = (del)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localdel.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localdel.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localdel.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localdel.GRx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localdel.FxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localdel.GDa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdel.GRt = ((btn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localdel.HsO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localdel.HbT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localdel.GDf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localdel.HsP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        localdel.AesKey = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.del
 * JD-Core Version:    0.7.0.1
 */