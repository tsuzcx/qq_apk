package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buj
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public crm DPU;
  public String DPY;
  public String EhE;
  public int Fkw;
  public String hkR;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43104);
        throw paramVarArgs;
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(1, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      if (this.hkR != null) {
        paramVarArgs.d(2, this.hkR);
      }
      paramVarArgs.aR(3, this.ndI);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.Fkw);
      if (this.DPY != null) {
        paramVarArgs.d(6, this.DPY);
      }
      if (this.EhE != null) {
        paramVarArgs.d(9, this.EhE);
      }
      AppMethodBeat.o(43104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPU == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.a.lm(1, this.DPU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hkR);
      }
      i = i + f.a.a.b.b.a.bx(3, this.ndI) + f.a.a.b.b.a.bx(4, this.CreateTime) + f.a.a.b.b.a.bx(5, this.Fkw);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPY);
      }
      i = paramInt;
      if (this.EhE != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EhE);
      }
      AppMethodBeat.o(43104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DPU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(43104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buj localbuj = (buj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(43104);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuj.DPU = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43104);
          return 0;
        case 2: 
          localbuj.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43104);
          return 0;
        case 3: 
          localbuj.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43104);
          return 0;
        case 4: 
          localbuj.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43104);
          return 0;
        case 5: 
          localbuj.Fkw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43104);
          return 0;
        case 6: 
          localbuj.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43104);
          return 0;
        }
        localbuj.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(43104);
        return 0;
      }
      AppMethodBeat.o(43104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buj
 * JD-Core Version:    0.7.0.1
 */