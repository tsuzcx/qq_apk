package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aek
  extends dyl
{
  public int CPw;
  public LinkedList<cwz> RIk;
  public eaf SqT;
  public eae SqU;
  public String SqV;
  public int iWB;
  public String lVG;
  
  public aek()
  {
    AppMethodBeat.i(101797);
    this.RIk = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SqT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SqT != null)
      {
        paramVarArgs.oE(2, this.SqT.computeSize());
        this.SqT.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.iWB);
      paramVarArgs.e(4, 8, this.RIk);
      paramVarArgs.aY(5, this.CPw);
      if (this.SqU != null)
      {
        paramVarArgs.oE(6, this.SqU.computeSize());
        this.SqU.writeFields(paramVarArgs);
      }
      if (this.SqV != null) {
        paramVarArgs.f(7, this.SqV);
      }
      if (this.lVG != null) {
        paramVarArgs.f(8, this.lVG);
      }
      AppMethodBeat.o(101798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SqT != null) {
        i = paramInt + g.a.a.a.oD(2, this.SqT.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.iWB) + g.a.a.a.c(4, 8, this.RIk) + g.a.a.b.b.a.bM(5, this.CPw);
      paramInt = i;
      if (this.SqU != null) {
        paramInt = i + g.a.a.a.oD(6, this.SqU.computeSize());
      }
      i = paramInt;
      if (this.SqV != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SqV);
      }
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lVG);
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SqT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aek localaek = (aek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localaek.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localaek.SqT = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localaek.iWB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwz)localObject2).parseFrom((byte[])localObject1);
            }
            localaek.RIk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localaek.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101798);
          return 0;
        case 6: 
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
            localaek.SqU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 7: 
          localaek.SqV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101798);
          return 0;
        }
        localaek.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(101798);
        return 0;
      }
      AppMethodBeat.o(101798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aek
 * JD-Core Version:    0.7.0.1
 */