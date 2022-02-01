package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctr
  extends cqk
{
  public LinkedList<ebu> DSZ;
  public boolean ERy;
  public int FCh;
  public ebl FFo;
  public int FFp;
  public com.tencent.mm.bw.b FFq;
  public String FFr;
  public int FvC;
  public String Title;
  public int ncL;
  public int ndI;
  public int ndl;
  public int pAG;
  
  public ctr()
  {
    AppMethodBeat.i(117922);
    this.DSZ = new LinkedList();
    AppMethodBeat.o(117922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117923);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndl);
      paramVarArgs.aR(3, this.ndI);
      paramVarArgs.aR(4, this.FvC);
      paramVarArgs.aR(5, this.ncL);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.FFo != null)
      {
        paramVarArgs.ln(7, this.FFo.computeSize());
        this.FFo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.DSZ);
      paramVarArgs.aR(9, this.FCh);
      paramVarArgs.aR(10, this.FFp);
      paramVarArgs.bl(11, this.ERy);
      if (this.FFq != null) {
        paramVarArgs.c(12, this.FFq);
      }
      paramVarArgs.aR(13, this.pAG);
      if (this.FFr != null) {
        paramVarArgs.d(14, this.FFr);
      }
      AppMethodBeat.o(117923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndl) + f.a.a.b.b.a.bx(3, this.ndI) + f.a.a.b.b.a.bx(4, this.FvC) + f.a.a.b.b.a.bx(5, this.ncL);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt;
      if (this.FFo != null) {
        i = paramInt + f.a.a.a.lm(7, this.FFo.computeSize());
      }
      i = i + f.a.a.a.c(8, 8, this.DSZ) + f.a.a.b.b.a.bx(9, this.FCh) + f.a.a.b.b.a.bx(10, this.FFp) + (f.a.a.b.b.a.fK(11) + 1);
      paramInt = i;
      if (this.FFq != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.FFq);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.pAG);
      paramInt = i;
      if (this.FFr != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FFr);
      }
      AppMethodBeat.o(117923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DSZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(117923);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctr localctr = (ctr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117923);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 2: 
          localctr.ndl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        case 3: 
          localctr.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        case 4: 
          localctr.FvC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        case 5: 
          localctr.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        case 6: 
          localctr.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117923);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctr.FFo = ((ebl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctr.DSZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 9: 
          localctr.FCh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        case 10: 
          localctr.FFp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        case 11: 
          localctr.ERy = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(117923);
          return 0;
        case 12: 
          localctr.FFq = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(117923);
          return 0;
        case 13: 
          localctr.pAG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117923);
          return 0;
        }
        localctr.FFr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117923);
        return 0;
      }
      AppMethodBeat.o(117923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctr
 * JD-Core Version:    0.7.0.1
 */