package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aui
  extends cqk
{
  public boolean EMK;
  public int EML;
  public int EMM;
  public rm EMN;
  public boolean EMO;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.bl(4, this.EMK);
      paramVarArgs.aR(5, this.EML);
      paramVarArgs.aR(6, this.EMM);
      if (this.EMN != null)
      {
        paramVarArgs.ln(7, this.EMN.computeSize());
        this.EMN.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(8, this.EMO);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + (f.a.a.b.b.a.fK(4) + 1) + f.a.a.b.b.a.bx(5, this.EML) + f.a.a.b.b.a.bx(6, this.EMM);
      paramInt = i;
      if (this.EMN != null) {
        paramInt = i + f.a.a.a.lm(7, this.EMN.computeSize());
      }
      i = f.a.a.b.b.a.fK(8);
      AppMethodBeat.o(114007);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aui localaui = (aui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
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
            localaui.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localaui.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localaui.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localaui.EMK = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localaui.EML = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localaui.EMM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaui.EMN = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localaui.EMO = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aui
 * JD-Core Version:    0.7.0.1
 */