package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vj
  extends cwj
{
  public LinkedList<Integer> GmJ;
  public int GmL;
  public String GmV;
  public String Gnb;
  public String Gne;
  public String Gng;
  public String Gnh;
  public String Gnk;
  public String Gnl;
  public String Gnm;
  public String desc;
  public int dmy;
  public String phe;
  public String yoq;
  
  public vj()
  {
    AppMethodBeat.i(72440);
    this.GmJ = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.Gnb != null) {
        paramVarArgs.d(4, this.Gnb);
      }
      paramVarArgs.e(5, 2, this.GmJ);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      if (this.Gnk != null) {
        paramVarArgs.d(7, this.Gnk);
      }
      if (this.yoq != null) {
        paramVarArgs.d(8, this.yoq);
      }
      if (this.Gne != null) {
        paramVarArgs.d(9, this.Gne);
      }
      if (this.Gng != null) {
        paramVarArgs.d(10, this.Gng);
      }
      if (this.Gnh != null) {
        paramVarArgs.d(11, this.Gnh);
      }
      paramVarArgs.aS(12, this.GmL);
      if (this.GmV != null) {
        paramVarArgs.d(13, this.GmV);
      }
      if (this.Gnl != null) {
        paramVarArgs.d(14, this.Gnl);
      }
      if (this.Gnm != null) {
        paramVarArgs.d(15, this.Gnm);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1189;
      }
    }
    label1189:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.Gnb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Gnb);
      }
      i += f.a.a.a.c(5, 2, this.GmJ);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt;
      if (this.Gnk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gnk);
      }
      paramInt = i;
      if (this.yoq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.yoq);
      }
      i = paramInt;
      if (this.Gne != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gne);
      }
      paramInt = i;
      if (this.Gng != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Gng);
      }
      i = paramInt;
      if (this.Gnh != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Gnh);
      }
      i += f.a.a.b.b.a.bz(12, this.GmL);
      paramInt = i;
      if (this.GmV != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GmV);
      }
      i = paramInt;
      if (this.Gnl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Gnl);
      }
      paramInt = i;
      if (this.Gnm != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Gnm);
      }
      AppMethodBeat.o(72441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GmJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vj localvj = (vj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localvj.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localvj.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localvj.Gnb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localvj.GmJ.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localvj.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localvj.Gnk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localvj.yoq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localvj.Gne = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localvj.Gng = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localvj.Gnh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localvj.GmL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localvj.GmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localvj.Gnl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
        localvj.Gnm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vj
 * JD-Core Version:    0.7.0.1
 */