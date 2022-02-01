package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpy
  extends cqk
{
  public String Ewu;
  public int FeP;
  public int FeR;
  public LinkedList<bpw> FeT;
  public LinkedList<bpw> FeU;
  
  public bpy()
  {
    AppMethodBeat.i(155436);
    this.FeT = new LinkedList();
    this.FeU = new LinkedList();
    AppMethodBeat.o(155436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(2, this.Ewu);
      }
      paramVarArgs.aR(3, this.FeP);
      paramVarArgs.e(4, 8, this.FeT);
      paramVarArgs.aR(5, this.FeR);
      paramVarArgs.e(6, 8, this.FeU);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ewu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ewu);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FeP);
      int j = f.a.a.a.c(4, 8, this.FeT);
      int k = f.a.a.b.b.a.bx(5, this.FeR);
      int m = f.a.a.a.c(6, 8, this.FeU);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FeT.clear();
        this.FeU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpy localbpy = (bpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
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
            localbpy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localbpy.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localbpy.FeP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpy.FeT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localbpy.FeR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpy.FeU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      AppMethodBeat.o(155437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpy
 * JD-Core Version:    0.7.0.1
 */