package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abo
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public bxq GtA;
  public ary GtB;
  public arz GtC;
  public jb GtD;
  public int Gtw;
  public LinkedList<bzh> Gtx;
  public int Gty;
  public String Gtz;
  public String Title;
  public String Url;
  
  public abo()
  {
    AppMethodBeat.i(125718);
    this.Gtx = new LinkedList();
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
      paramVarArgs.aS(2, this.Gtw);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.Gtx);
      paramVarArgs.aS(6, this.Gty);
      if (this.Gtz != null) {
        paramVarArgs.d(7, this.Gtz);
      }
      if (this.GtA != null)
      {
        paramVarArgs.lJ(8, this.GtA.computeSize());
        this.GtA.writeFields(paramVarArgs);
      }
      if (this.GtB != null)
      {
        paramVarArgs.lJ(9, this.GtB.computeSize());
        this.GtB.writeFields(paramVarArgs);
      }
      if (this.GtC != null)
      {
        paramVarArgs.lJ(10, this.GtC.computeSize());
        this.GtC.writeFields(paramVarArgs);
      }
      if (this.GtD != null)
      {
        paramVarArgs.lJ(11, this.GtD.computeSize());
        this.GtD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label1250;
      }
    }
    label1250:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gtw);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i = i + f.a.a.a.c(5, 8, this.Gtx) + f.a.a.b.b.a.bz(6, this.Gty);
      paramInt = i;
      if (this.Gtz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gtz);
      }
      i = paramInt;
      if (this.GtA != null) {
        i = paramInt + f.a.a.a.lI(8, this.GtA.computeSize());
      }
      paramInt = i;
      if (this.GtB != null) {
        paramInt = i + f.a.a.a.lI(9, this.GtB.computeSize());
      }
      i = paramInt;
      if (this.GtC != null) {
        i = paramInt + f.a.a.a.lI(10, this.GtC.computeSize());
      }
      paramInt = i;
      if (this.GtD != null) {
        paramInt = i + f.a.a.a.lI(11, this.GtD.computeSize());
      }
      AppMethodBeat.o(125719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gtx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abo localabo = (abo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localabo.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localabo.Gtw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localabo.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localabo.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabo.Gtx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localabo.Gty = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localabo.Gtz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabo.GtA = ((bxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ary();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ary)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabo.GtB = ((ary)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabo.GtC = ((arz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((jb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabo.GtD = ((jb)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abo
 * JD-Core Version:    0.7.0.1
 */