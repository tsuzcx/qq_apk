package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duz
  extends com.tencent.mm.bx.a
{
  public int FxO;
  public String GtA;
  public String Guj;
  public SKBuiltinBuffer_t HHA;
  public String HHs;
  public int HHt;
  public String HHu;
  public String HHv;
  public int HHw;
  public String HHx;
  public int HHy;
  public SKBuiltinBuffer_t HHz;
  public String HnU;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yhw != null) {
        paramVarArgs.d(1, this.yhw);
      }
      if (this.HHs != null) {
        paramVarArgs.d(2, this.HHs);
      }
      if (this.Guj != null) {
        paramVarArgs.d(3, this.Guj);
      }
      paramVarArgs.aS(4, this.HHt);
      if (this.HnU != null) {
        paramVarArgs.d(5, this.HnU);
      }
      if (this.HHu != null) {
        paramVarArgs.d(6, this.HHu);
      }
      if (this.HHv != null) {
        paramVarArgs.d(7, this.HHv);
      }
      paramVarArgs.aS(8, this.HHw);
      if (this.HHx != null) {
        paramVarArgs.d(9, this.HHx);
      }
      paramVarArgs.aS(10, this.HHy);
      if (this.HHz != null)
      {
        paramVarArgs.lC(11, this.HHz.computeSize());
        this.HHz.writeFields(paramVarArgs);
      }
      if (this.GtA != null) {
        paramVarArgs.d(12, this.GtA);
      }
      paramVarArgs.aS(13, this.FxO);
      if (this.HHA != null)
      {
        paramVarArgs.lC(14, this.HHA.computeSize());
        this.HHA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhw == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.yhw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HHs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HHs);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Guj);
      }
      i += f.a.a.b.b.a.bz(4, this.HHt);
      paramInt = i;
      if (this.HnU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HnU);
      }
      i = paramInt;
      if (this.HHu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HHu);
      }
      paramInt = i;
      if (this.HHv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HHv);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HHw);
      paramInt = i;
      if (this.HHx != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HHx);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HHy);
      paramInt = i;
      if (this.HHz != null) {
        paramInt = i + f.a.a.a.lB(11, this.HHz.computeSize());
      }
      i = paramInt;
      if (this.GtA != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GtA);
      }
      i += f.a.a.b.b.a.bz(13, this.FxO);
      paramInt = i;
      if (this.HHA != null) {
        paramInt = i + f.a.a.a.lB(14, this.HHA.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duz localduz = (duz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localduz.yhw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localduz.HHs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localduz.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localduz.HHt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localduz.HnU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localduz.HHu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localduz.HHv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localduz.HHw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localduz.HHx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localduz.HHy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduz.HHz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localduz.GtA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localduz.FxO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152723);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localduz.HHA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      AppMethodBeat.o(152723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duz
 * JD-Core Version:    0.7.0.1
 */