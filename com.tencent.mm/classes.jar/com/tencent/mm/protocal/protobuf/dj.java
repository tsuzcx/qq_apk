package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dj
  extends com.tencent.mm.bw.a
{
  public String DQs;
  public String DQt;
  public String DQu;
  public aid DQv;
  public int DQw;
  public int channel;
  public String iAz;
  public int scene;
  public int wJT;
  public String wLu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQs == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.DQu == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.DQs != null) {
        paramVarArgs.d(1, this.DQs);
      }
      if (this.DQt != null) {
        paramVarArgs.d(2, this.DQt);
      }
      paramVarArgs.aR(3, this.channel);
      paramVarArgs.aR(4, this.wJT);
      paramVarArgs.aR(5, this.scene);
      if (this.DQu != null) {
        paramVarArgs.d(6, this.DQu);
      }
      if (this.DQv != null)
      {
        paramVarArgs.ln(7, this.DQv.computeSize());
        this.DQv.writeFields(paramVarArgs);
      }
      if (this.iAz != null) {
        paramVarArgs.d(8, this.iAz);
      }
      if (this.wLu != null) {
        paramVarArgs.d(9, this.wLu);
      }
      paramVarArgs.aR(10, this.DQw);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQs == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.b.b.a.e(1, this.DQs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DQt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DQt);
      }
      i = i + f.a.a.b.b.a.bx(3, this.channel) + f.a.a.b.b.a.bx(4, this.wJT) + f.a.a.b.b.a.bx(5, this.scene);
      paramInt = i;
      if (this.DQu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DQu);
      }
      i = paramInt;
      if (this.DQv != null) {
        i = paramInt + f.a.a.a.lm(7, this.DQv.computeSize());
      }
      paramInt = i;
      if (this.iAz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iAz);
      }
      i = paramInt;
      if (this.wLu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.wLu);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.DQw);
      AppMethodBeat.o(91349);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DQs == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.DQu == null)
        {
          paramVarArgs = new b("Not all required fields were included: payok_checksign");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91349);
          return -1;
        case 1: 
          localdj.DQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localdj.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localdj.channel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localdj.wJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localdj.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localdj.DQu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aid();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.DQv = ((aid)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localdj.iAz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localdj.wLu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91349);
          return 0;
        }
        localdj.DQw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dj
 * JD-Core Version:    0.7.0.1
 */