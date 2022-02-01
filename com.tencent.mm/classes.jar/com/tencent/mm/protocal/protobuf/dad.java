package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dad
  extends cvw
{
  public int FQT;
  public int Ghi;
  public int Ghj;
  public String Ghk;
  public int GwZ;
  public eq HJH;
  public String HJI;
  public String HJJ;
  public int HJK;
  public int HJL;
  public String Md5;
  public String jfY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HJH != null)
      {
        paramVarArgs.lJ(2, this.HJH.computeSize());
        this.HJH.writeFields(paramVarArgs);
      }
      if (this.HJI != null) {
        paramVarArgs.d(3, this.HJI);
      }
      paramVarArgs.aS(4, this.GwZ);
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      paramVarArgs.aS(6, this.FQT);
      if (this.jfY != null) {
        paramVarArgs.d(7, this.jfY);
      }
      if (this.HJJ != null) {
        paramVarArgs.d(8, this.HJJ);
      }
      paramVarArgs.aS(9, this.HJK);
      paramVarArgs.aS(10, this.Ghi);
      paramVarArgs.aS(11, this.Ghj);
      paramVarArgs.aS(12, this.HJL);
      if (this.Ghk != null) {
        paramVarArgs.d(13, this.Ghk);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1109;
      }
    }
    label1109:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HJH != null) {
        paramInt = i + f.a.a.a.lI(2, this.HJH.computeSize());
      }
      i = paramInt;
      if (this.HJI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HJI);
      }
      i += f.a.a.b.b.a.bz(4, this.GwZ);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FQT);
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jfY);
      }
      i = paramInt;
      if (this.HJJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HJJ);
      }
      i = i + f.a.a.b.b.a.bz(9, this.HJK) + f.a.a.b.b.a.bz(10, this.Ghi) + f.a.a.b.b.a.bz(11, this.Ghj) + f.a.a.b.b.a.bz(12, this.HJL);
      paramInt = i;
      if (this.Ghk != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Ghk);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HJH == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dad localdad = (dad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdad.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdad.HJH = ((eq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localdad.HJI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localdad.GwZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localdad.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localdad.FQT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localdad.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localdad.HJJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localdad.HJK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localdad.Ghi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localdad.Ghj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localdad.HJL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32426);
          return 0;
        }
        localdad.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dad
 * JD-Core Version:    0.7.0.1
 */