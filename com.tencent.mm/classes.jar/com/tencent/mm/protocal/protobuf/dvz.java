package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dvz
  extends cvw
{
  public int FSQ;
  public SKBuiltinBuffer_t FSi;
  public SKBuiltinBuffer_t FSj;
  public String GXa;
  public int Ibp;
  public LinkedList<dvw> Ibq;
  public int Ibr;
  public LinkedList<Integer> Ibs;
  public int Ibt;
  public LinkedList<dvy> Ibu;
  public int Ibv;
  
  public dvz()
  {
    AppMethodBeat.i(152726);
    this.Ibq = new LinkedList();
    this.Ibs = new LinkedList();
    this.Ibu = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FSQ);
      paramVarArgs.aS(3, this.Ibp);
      paramVarArgs.e(4, 8, this.Ibq);
      if (this.GXa != null) {
        paramVarArgs.d(5, this.GXa);
      }
      paramVarArgs.aS(6, this.Ibr);
      paramVarArgs.f(7, 2, this.Ibs);
      paramVarArgs.aS(8, this.Ibt);
      paramVarArgs.e(9, 8, this.Ibu);
      if (this.FSi != null)
      {
        paramVarArgs.lJ(10, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(11, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.Ibv);
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1253;
      }
    }
    label1253:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FSQ) + f.a.a.b.b.a.bz(3, this.Ibp) + f.a.a.a.c(4, 8, this.Ibq);
      paramInt = i;
      if (this.GXa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GXa);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Ibr) + f.a.a.a.d(7, 2, this.Ibs) + f.a.a.b.b.a.bz(8, this.Ibt) + f.a.a.a.c(9, 8, this.Ibu);
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lI(10, this.FSi.computeSize());
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.a.lI(11, this.FSj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(12, this.Ibv);
      AppMethodBeat.o(152727);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ibq.clear();
        this.Ibs.clear();
        this.Ibu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvz localdvz = (dvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localdvz.FSQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localdvz.Ibp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.Ibq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localdvz.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localdvz.Ibr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localdvz.Ibs = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localdvz.Ibt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.Ibu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.FSj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        }
        localdvz.Ibv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvz
 * JD-Core Version:    0.7.0.1
 */