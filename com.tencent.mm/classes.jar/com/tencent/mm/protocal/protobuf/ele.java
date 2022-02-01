package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ele
  extends dyy
{
  public int CqN;
  public LinkedList<SnsObject> RPF;
  public int TGK;
  public String UlA;
  public int UlE;
  public ekt UlF;
  public eae Uld;
  public int Unb;
  public int Unc;
  public LinkedList<dq> Und;
  public int Une;
  public LinkedList<dtv> Unf;
  public int Ung;
  public LinkedList<afi> Unh;
  public int Uni;
  public LinkedList<Long> Unj;
  public LinkedList<Integer> Unk;
  public eae Unl;
  
  public ele()
  {
    AppMethodBeat.i(125828);
    this.RPF = new LinkedList();
    this.Und = new LinkedList();
    this.Unf = new LinkedList();
    this.Unh = new LinkedList();
    this.Unj = new LinkedList();
    this.Unk = new LinkedList();
    AppMethodBeat.o(125828);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125829);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UlA != null) {
        paramVarArgs.f(2, this.UlA);
      }
      paramVarArgs.aY(3, this.TGK);
      paramVarArgs.e(4, 8, this.RPF);
      paramVarArgs.aY(5, this.Unb);
      paramVarArgs.aY(6, this.UlE);
      paramVarArgs.aY(7, this.CqN);
      if (this.UlF != null)
      {
        paramVarArgs.oE(8, this.UlF.computeSize());
        this.UlF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.Unc);
      paramVarArgs.e(10, 8, this.Und);
      if (this.Uld != null)
      {
        paramVarArgs.oE(11, this.Uld.computeSize());
        this.Uld.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.Une);
      paramVarArgs.e(13, 8, this.Unf);
      paramVarArgs.aY(14, this.Ung);
      paramVarArgs.e(15, 8, this.Unh);
      paramVarArgs.aY(16, this.Uni);
      paramVarArgs.f(17, 3, this.Unj);
      paramVarArgs.f(18, 2, this.Unk);
      if (this.Unl != null)
      {
        paramVarArgs.oE(19, this.Unl.computeSize());
        this.Unl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1764;
      }
    }
    label1764:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UlA);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TGK) + g.a.a.a.c(4, 8, this.RPF) + g.a.a.b.b.a.bM(5, this.Unb) + g.a.a.b.b.a.bM(6, this.UlE) + g.a.a.b.b.a.bM(7, this.CqN);
      paramInt = i;
      if (this.UlF != null) {
        paramInt = i + g.a.a.a.oD(8, this.UlF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.Unc) + g.a.a.a.c(10, 8, this.Und);
      paramInt = i;
      if (this.Uld != null) {
        paramInt = i + g.a.a.a.oD(11, this.Uld.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Une) + g.a.a.a.c(13, 8, this.Unf) + g.a.a.b.b.a.bM(14, this.Ung) + g.a.a.a.c(15, 8, this.Unh) + g.a.a.b.b.a.bM(16, this.Uni) + g.a.a.a.d(17, 3, this.Unj) + g.a.a.a.d(18, 2, this.Unk);
      paramInt = i;
      if (this.Unl != null) {
        paramInt = i + g.a.a.a.oD(19, this.Unl.computeSize());
      }
      AppMethodBeat.o(125829);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPF.clear();
        this.Und.clear();
        this.Unf.clear();
        this.Unh.clear();
        this.Unj.clear();
        this.Unk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ele localele = (ele)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localele.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localele.UlA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localele.TGK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localele.RPF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localele.Unb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localele.UlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localele.CqN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekt)localObject2).parseFrom((byte[])localObject1);
            }
            localele.UlF = ((ekt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localele.Unc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dq)localObject2).parseFrom((byte[])localObject1);
            }
            localele.Und.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localele.Uld = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localele.Une = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtv)localObject2).parseFrom((byte[])localObject1);
            }
            localele.Unf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localele.Ung = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afi)localObject2).parseFrom((byte[])localObject1);
            }
            localele.Unh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localele.Uni = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localele.Unj = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUv();
          AppMethodBeat.o(125829);
          return 0;
        case 18: 
          localele.Unk = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(125829);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localele.Unl = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ele
 * JD-Core Version:    0.7.0.1
 */