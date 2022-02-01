package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dcj
  extends dyy
{
  public int REo;
  public int Saq;
  public eae TJJ;
  public eae TJK;
  public int TJL;
  public int TJM;
  public LinkedList<abu> TJN;
  
  public dcj()
  {
    AppMethodBeat.i(133182);
    this.TJN = new LinkedList();
    AppMethodBeat.o(133182);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133183);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.TJJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.TJK == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TJJ != null)
      {
        paramVarArgs.oE(2, this.TJJ.computeSize());
        this.TJJ.writeFields(paramVarArgs);
      }
      if (this.TJK != null)
      {
        paramVarArgs.oE(3, this.TJK.computeSize());
        this.TJK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Saq);
      paramVarArgs.aY(5, this.TJL);
      paramVarArgs.aY(6, this.TJM);
      paramVarArgs.e(7, 8, this.TJN);
      paramVarArgs.aY(8, this.REo);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1006;
      }
    }
    label1006:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TJJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.TJJ.computeSize());
      }
      i = paramInt;
      if (this.TJK != null) {
        i = paramInt + g.a.a.a.oD(3, this.TJK.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Saq);
      int j = g.a.a.b.b.a.bM(5, this.TJL);
      int k = g.a.a.b.b.a.bM(6, this.TJM);
      int m = g.a.a.a.c(7, 8, this.TJN);
      int n = g.a.a.b.b.a.bM(8, this.REo);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TJN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.TJJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.TJK == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133183);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcj localdcj = (dcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
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
            localdcj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 2: 
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
            localdcj.TJJ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 3: 
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
            localdcj.TJK = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localdcj.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localdcj.TJL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localdcj.TJM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abu)localObject2).parseFrom((byte[])localObject1);
            }
            localdcj.TJN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localdcj.REo = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcj
 * JD-Core Version:    0.7.0.1
 */