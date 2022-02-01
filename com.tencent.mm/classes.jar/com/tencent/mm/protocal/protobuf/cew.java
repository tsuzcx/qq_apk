package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cew
  extends cld
{
  public String Ebn;
  public int Ebo;
  public String Ebp;
  public String Ebq;
  public String Ebr;
  public String Ebs;
  public int dcG;
  public String hJE;
  public String nTK;
  public int state;
  public int tav;
  public String vuP;
  public String vuQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.aR(4, this.state);
      if (this.Ebn != null) {
        paramVarArgs.d(5, this.Ebn);
      }
      paramVarArgs.aR(6, this.tav);
      paramVarArgs.aR(7, this.Ebo);
      if (this.vuP != null) {
        paramVarArgs.d(8, this.vuP);
      }
      if (this.Ebp != null) {
        paramVarArgs.d(9, this.Ebp);
      }
      if (this.vuQ != null) {
        paramVarArgs.d(10, this.vuQ);
      }
      if (this.Ebq != null) {
        paramVarArgs.d(11, this.Ebq);
      }
      if (this.Ebr != null) {
        paramVarArgs.d(12, this.Ebr);
      }
      if (this.Ebs != null) {
        paramVarArgs.d(14, this.Ebs);
      }
      if (this.hJE != null) {
        paramVarArgs.d(15, this.hJE);
      }
      AppMethodBeat.o(72567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.state);
      paramInt = i;
      if (this.Ebn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ebn);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.tav) + f.a.a.b.b.a.bA(7, this.Ebo);
      paramInt = i;
      if (this.vuP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.vuP);
      }
      i = paramInt;
      if (this.Ebp != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ebp);
      }
      paramInt = i;
      if (this.vuQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.vuQ);
      }
      i = paramInt;
      if (this.Ebq != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Ebq);
      }
      paramInt = i;
      if (this.Ebr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Ebr);
      }
      i = paramInt;
      if (this.Ebs != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Ebs);
      }
      paramInt = i;
      if (this.hJE != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.hJE);
      }
      AppMethodBeat.o(72567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cew localcew = (cew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcew.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localcew.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localcew.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localcew.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localcew.Ebn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localcew.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localcew.Ebo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localcew.vuP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localcew.Ebp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localcew.vuQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localcew.Ebq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localcew.Ebr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localcew.Ebs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localcew.hJE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cew
 * JD-Core Version:    0.7.0.1
 */