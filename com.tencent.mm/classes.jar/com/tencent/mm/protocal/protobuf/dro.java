package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dro
  extends com.tencent.mm.bw.a
{
  public LinkedList<drm> FJS;
  public int HCb;
  public String HYl;
  public String HYm;
  public buz HYn;
  public int HYo;
  public drn HYp;
  public drn HYq;
  public String desc;
  public String title;
  
  public dro()
  {
    AppMethodBeat.i(72617);
    this.FJS = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.HYl != null) {
        paramVarArgs.d(3, this.HYl);
      }
      if (this.HYm != null) {
        paramVarArgs.d(4, this.HYm);
      }
      if (this.HYn != null)
      {
        paramVarArgs.lJ(5, this.HYn.computeSize());
        this.HYn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.FJS);
      paramVarArgs.aS(7, this.HCb);
      paramVarArgs.aS(8, this.HYo);
      if (this.HYp != null)
      {
        paramVarArgs.lJ(9, this.HYp.computeSize());
        this.HYp.writeFields(paramVarArgs);
      }
      if (this.HYq != null)
      {
        paramVarArgs.lJ(10, this.HYq.computeSize());
        this.HYq.writeFields(paramVarArgs);
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
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.HYl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HYl);
      }
      paramInt = i;
      if (this.HYm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HYm);
      }
      i = paramInt;
      if (this.HYn != null) {
        i = paramInt + f.a.a.a.lI(5, this.HYn.computeSize());
      }
      i = i + f.a.a.a.c(6, 8, this.FJS) + f.a.a.b.b.a.bz(7, this.HCb) + f.a.a.b.b.a.bz(8, this.HYo);
      paramInt = i;
      if (this.HYp != null) {
        paramInt = i + f.a.a.a.lI(9, this.HYp.computeSize());
      }
      i = paramInt;
      if (this.HYq != null) {
        i = paramInt + f.a.a.a.lI(10, this.HYq.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dro localdro = (dro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localdro.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localdro.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localdro.HYl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localdro.HYm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdro.HYn = ((buz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdro.FJS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localdro.HCb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localdro.HYo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdro.HYp = ((drn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new drn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((drn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdro.HYq = ((drn)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dro
 * JD-Core Version:    0.7.0.1
 */