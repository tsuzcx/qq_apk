package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avb
  extends cqk
{
  public String ENf;
  public int ENg;
  public cqz ENh;
  public String ENi;
  public long eyr;
  public int fsn;
  public String fso;
  public int fsp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ENf != null) {
        paramVarArgs.d(2, this.ENf);
      }
      paramVarArgs.aR(3, this.fsn);
      if (this.fso != null) {
        paramVarArgs.d(4, this.fso);
      }
      paramVarArgs.aR(5, this.fsp);
      paramVarArgs.aR(6, this.ENg);
      paramVarArgs.aO(7, this.eyr);
      if (this.ENh != null)
      {
        paramVarArgs.ln(8, this.ENh.computeSize());
        this.ENh.writeFields(paramVarArgs);
      }
      if (this.ENi != null) {
        paramVarArgs.d(9, this.ENi);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ENf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ENf);
      }
      i += f.a.a.b.b.a.bx(3, this.fsn);
      paramInt = i;
      if (this.fso != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fso);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.fsp) + f.a.a.b.b.a.bx(6, this.ENg) + f.a.a.b.b.a.p(7, this.eyr);
      paramInt = i;
      if (this.ENh != null) {
        paramInt = i + f.a.a.a.lm(8, this.ENh.computeSize());
      }
      i = paramInt;
      if (this.ENi != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ENi);
      }
      AppMethodBeat.o(101808);
      return i;
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
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avb localavb = (avb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localavb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localavb.ENf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localavb.fsn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localavb.fso = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localavb.fsp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localavb.ENg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localavb.eyr = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(101808);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavb.ENh = ((cqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        }
        localavb.ENi = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avb
 * JD-Core Version:    0.7.0.1
 */