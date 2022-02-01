package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvw
  extends com.tencent.mm.bw.a
{
  public int FQm;
  public String GMZ;
  public String GNI;
  public String HHu;
  public String Ibf;
  public int Ibg;
  public String Ibh;
  public String Ibi;
  public int Ibj;
  public String Ibk;
  public int Ibl;
  public SKBuiltinBuffer_t Ibm;
  public SKBuiltinBuffer_t Ibn;
  public String yxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yxn != null) {
        paramVarArgs.d(1, this.yxn);
      }
      if (this.Ibf != null) {
        paramVarArgs.d(2, this.Ibf);
      }
      if (this.GNI != null) {
        paramVarArgs.d(3, this.GNI);
      }
      paramVarArgs.aS(4, this.Ibg);
      if (this.HHu != null) {
        paramVarArgs.d(5, this.HHu);
      }
      if (this.Ibh != null) {
        paramVarArgs.d(6, this.Ibh);
      }
      if (this.Ibi != null) {
        paramVarArgs.d(7, this.Ibi);
      }
      paramVarArgs.aS(8, this.Ibj);
      if (this.Ibk != null) {
        paramVarArgs.d(9, this.Ibk);
      }
      paramVarArgs.aS(10, this.Ibl);
      if (this.Ibm != null)
      {
        paramVarArgs.lJ(11, this.Ibm.computeSize());
        this.Ibm.writeFields(paramVarArgs);
      }
      if (this.GMZ != null) {
        paramVarArgs.d(12, this.GMZ);
      }
      paramVarArgs.aS(13, this.FQm);
      if (this.Ibn != null)
      {
        paramVarArgs.lJ(14, this.Ibn.computeSize());
        this.Ibn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yxn == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.yxn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ibf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ibf);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GNI);
      }
      i += f.a.a.b.b.a.bz(4, this.Ibg);
      paramInt = i;
      if (this.HHu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HHu);
      }
      i = paramInt;
      if (this.Ibh != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Ibh);
      }
      paramInt = i;
      if (this.Ibi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ibi);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Ibj);
      paramInt = i;
      if (this.Ibk != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Ibk);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.Ibl);
      paramInt = i;
      if (this.Ibm != null) {
        paramInt = i + f.a.a.a.lI(11, this.Ibm.computeSize());
      }
      i = paramInt;
      if (this.GMZ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GMZ);
      }
      i += f.a.a.b.b.a.bz(13, this.FQm);
      paramInt = i;
      if (this.Ibn != null) {
        paramInt = i + f.a.a.a.lI(14, this.Ibn.computeSize());
      }
      AppMethodBeat.o(152723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvw localdvw = (dvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152723);
          return -1;
        case 1: 
          localdvw.yxn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 2: 
          localdvw.Ibf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 3: 
          localdvw.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 4: 
          localdvw.Ibg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152723);
          return 0;
        case 5: 
          localdvw.HHu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 6: 
          localdvw.Ibh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 7: 
          localdvw.Ibi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 8: 
          localdvw.Ibj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152723);
          return 0;
        case 9: 
          localdvw.Ibk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 10: 
          localdvw.Ibl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152723);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvw.Ibm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152723);
          return 0;
        case 12: 
          localdvw.GMZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152723);
          return 0;
        case 13: 
          localdvw.FQm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152723);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvw.Ibn = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvw
 * JD-Core Version:    0.7.0.1
 */