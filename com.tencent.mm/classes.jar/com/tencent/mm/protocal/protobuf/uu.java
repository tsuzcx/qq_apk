package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class uu
  extends cwj
{
  public String DkG;
  public boolean GmG;
  public String GmH;
  public int GmI;
  public LinkedList<Integer> GmJ;
  public String GmK;
  public int GmL;
  public int GmM;
  public cru Gmp;
  public String desc;
  public int dmy;
  public String oGe;
  public String ofy;
  public String phe;
  public String ynq;
  
  public uu()
  {
    AppMethodBeat.i(72433);
    this.GmJ = new LinkedList();
    AppMethodBeat.o(72433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72434);
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
      paramVarArgs.bC(4, this.GmG);
      if (this.ynq != null) {
        paramVarArgs.d(5, this.ynq);
      }
      if (this.GmH != null) {
        paramVarArgs.d(6, this.GmH);
      }
      if (this.ofy != null) {
        paramVarArgs.d(7, this.ofy);
      }
      paramVarArgs.aS(8, this.GmI);
      if (this.desc != null) {
        paramVarArgs.d(9, this.desc);
      }
      if (this.DkG != null) {
        paramVarArgs.d(10, this.DkG);
      }
      paramVarArgs.e(11, 2, this.GmJ);
      if (this.GmK != null) {
        paramVarArgs.d(12, this.GmK);
      }
      if (this.oGe != null) {
        paramVarArgs.d(13, this.oGe);
      }
      paramVarArgs.aS(14, this.GmL);
      paramVarArgs.aS(15, this.GmM);
      if (this.Gmp != null)
      {
        paramVarArgs.lJ(16, this.Gmp.computeSize());
        this.Gmp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1289;
      }
    }
    label1289:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.ynq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ynq);
      }
      i = paramInt;
      if (this.GmH != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GmH);
      }
      paramInt = i;
      if (this.ofy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ofy);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GmI);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.desc);
      }
      i = paramInt;
      if (this.DkG != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DkG);
      }
      i += f.a.a.a.c(11, 2, this.GmJ);
      paramInt = i;
      if (this.GmK != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GmK);
      }
      i = paramInt;
      if (this.oGe != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.oGe);
      }
      i = i + f.a.a.b.b.a.bz(14, this.GmL) + f.a.a.b.b.a.bz(15, this.GmM);
      paramInt = i;
      if (this.Gmp != null) {
        paramInt = i + f.a.a.a.lI(16, this.Gmp.computeSize());
      }
      AppMethodBeat.o(72434);
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
          AppMethodBeat.o(72434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uu localuu = (uu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72434);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
          return 0;
        case 2: 
          localuu.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72434);
          return 0;
        case 3: 
          localuu.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 4: 
          localuu.GmG = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72434);
          return 0;
        case 5: 
          localuu.ynq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 6: 
          localuu.GmH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 7: 
          localuu.ofy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 8: 
          localuu.GmI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72434);
          return 0;
        case 9: 
          localuu.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 10: 
          localuu.DkG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 11: 
          localuu.GmJ.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(72434);
          return 0;
        case 12: 
          localuu.GmK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 13: 
          localuu.oGe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 14: 
          localuu.GmL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72434);
          return 0;
        case 15: 
          localuu.GmM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cru();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localuu.Gmp = ((cru)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      AppMethodBeat.o(72434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uu
 * JD-Core Version:    0.7.0.1
 */