package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zf
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int EtA;
  public String EtB;
  public bsj EtC;
  public anx EtD;
  public any EtE;
  public int Ety;
  public LinkedList<btz> Etz;
  public String Title;
  public String Url;
  
  public zf()
  {
    AppMethodBeat.i(125718);
    this.Etz = new LinkedList();
    AppMethodBeat.o(125718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      paramVarArgs.aR(2, this.Ety);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.Etz);
      paramVarArgs.aR(6, this.EtA);
      if (this.EtB != null) {
        paramVarArgs.d(7, this.EtB);
      }
      if (this.EtC != null)
      {
        paramVarArgs.ln(8, this.EtC.computeSize());
        this.EtC.writeFields(paramVarArgs);
      }
      if (this.EtD != null)
      {
        paramVarArgs.ln(9, this.EtD.computeSize());
        this.EtD.writeFields(paramVarArgs);
      }
      if (this.EtE != null)
      {
        paramVarArgs.ln(10, this.EtE.computeSize());
        this.EtE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ety);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i = i + f.a.a.a.c(5, 8, this.Etz) + f.a.a.b.b.a.bx(6, this.EtA);
      paramInt = i;
      if (this.EtB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EtB);
      }
      i = paramInt;
      if (this.EtC != null) {
        i = paramInt + f.a.a.a.lm(8, this.EtC.computeSize());
      }
      paramInt = i;
      if (this.EtD != null) {
        paramInt = i + f.a.a.a.lm(9, this.EtD.computeSize());
      }
      i = paramInt;
      if (this.EtE != null) {
        i = paramInt + f.a.a.a.lm(10, this.EtE.computeSize());
      }
      AppMethodBeat.o(125719);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Etz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zf localzf = (zf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localzf.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localzf.Ety = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localzf.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localzf.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzf.Etz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localzf.EtA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localzf.EtB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzf.EtC = ((bsj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzf.EtD = ((anx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new any();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((any)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzf.EtE = ((any)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      AppMethodBeat.o(125719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zf
 * JD-Core Version:    0.7.0.1
 */