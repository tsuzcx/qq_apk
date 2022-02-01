package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class din
  extends com.tencent.mm.bw.a
{
  public LinkedList<yh> BYq;
  public cyv FRB;
  public boolean FRI;
  public LinkedList<dio> FRM;
  public String FRv;
  public String FRw;
  public String FRx;
  public String FRy;
  public long FRz;
  public String cZL;
  public int offset;
  public String qox;
  public int scene;
  
  public din()
  {
    AppMethodBeat.i(153010);
    this.FRM = new LinkedList();
    this.BYq = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRv != null) {
        paramVarArgs.d(1, this.FRv);
      }
      if (this.FRw != null) {
        paramVarArgs.d(2, this.FRw);
      }
      if (this.FRx != null) {
        paramVarArgs.d(3, this.FRx);
      }
      if (this.FRy != null) {
        paramVarArgs.d(4, this.FRy);
      }
      if (this.FRB != null)
      {
        paramVarArgs.ln(5, this.FRB.computeSize());
        this.FRB.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.FRz);
      if (this.qox != null) {
        paramVarArgs.d(7, this.qox);
      }
      paramVarArgs.aR(8, this.offset);
      paramVarArgs.bl(9, this.FRI);
      paramVarArgs.aR(10, this.scene);
      if (this.cZL != null) {
        paramVarArgs.d(11, this.cZL);
      }
      paramVarArgs.e(12, 8, this.FRM);
      paramVarArgs.e(13, 8, this.BYq);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FRv == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.FRv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FRw);
      }
      i = paramInt;
      if (this.FRx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FRx);
      }
      paramInt = i;
      if (this.FRy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FRy);
      }
      i = paramInt;
      if (this.FRB != null) {
        i = paramInt + f.a.a.a.lm(5, this.FRB.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.FRz);
      paramInt = i;
      if (this.qox != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.qox);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.offset) + (f.a.a.b.b.a.fK(9) + 1) + f.a.a.b.b.a.bx(10, this.scene);
      paramInt = i;
      if (this.cZL != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.cZL);
      }
      i = f.a.a.a.c(12, 8, this.FRM);
      int j = f.a.a.a.c(13, 8, this.BYq);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRM.clear();
        this.BYq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        din localdin = (din)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localdin.FRv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localdin.FRw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localdin.FRx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localdin.FRy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdin.FRB = ((cyv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localdin.FRz = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localdin.qox = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localdin.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localdin.FRI = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localdin.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localdin.cZL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dio();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdin.FRM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdin.BYq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.din
 * JD-Core Version:    0.7.0.1
 */