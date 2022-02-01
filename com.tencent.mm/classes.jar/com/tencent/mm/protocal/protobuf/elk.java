package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elk
  extends com.tencent.mm.bw.a
{
  public LinkedList<eli> KDk;
  public int MMP;
  public String Nkr;
  public String Nks;
  public cig Nkt;
  public int Nku;
  public elj Nkv;
  public elj Nkw;
  public String desc;
  public String title;
  
  public elk()
  {
    AppMethodBeat.i(72617);
    this.KDk = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.Nkr != null) {
        paramVarArgs.e(3, this.Nkr);
      }
      if (this.Nks != null) {
        paramVarArgs.e(4, this.Nks);
      }
      if (this.Nkt != null)
      {
        paramVarArgs.ni(5, this.Nkt.computeSize());
        this.Nkt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.KDk);
      paramVarArgs.aM(7, this.MMP);
      paramVarArgs.aM(8, this.Nku);
      if (this.Nkv != null)
      {
        paramVarArgs.ni(9, this.Nkv.computeSize());
        this.Nkv.writeFields(paramVarArgs);
      }
      if (this.Nkw != null)
      {
        paramVarArgs.ni(10, this.Nkw.computeSize());
        this.Nkw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.Nkr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nkr);
      }
      paramInt = i;
      if (this.Nks != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nks);
      }
      i = paramInt;
      if (this.Nkt != null) {
        i = paramInt + g.a.a.a.nh(5, this.Nkt.computeSize());
      }
      i = i + g.a.a.a.c(6, 8, this.KDk) + g.a.a.b.b.a.bu(7, this.MMP) + g.a.a.b.b.a.bu(8, this.Nku);
      paramInt = i;
      if (this.Nkv != null) {
        paramInt = i + g.a.a.a.nh(9, this.Nkv.computeSize());
      }
      i = paramInt;
      if (this.Nkw != null) {
        i = paramInt + g.a.a.a.nh(10, this.Nkw.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KDk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elk localelk = (elk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localelk.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localelk.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localelk.Nkr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localelk.Nks = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cig();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelk.Nkt = ((cig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eli();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eli)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelk.KDk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localelk.MMP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localelk.Nku = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new elj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((elj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelk.Nkv = ((elj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new elj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((elj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localelk.Nkw = ((elj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      AppMethodBeat.o(72618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elk
 * JD-Core Version:    0.7.0.1
 */