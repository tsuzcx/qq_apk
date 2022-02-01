package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class elh
  extends dyy
{
  public int HmZ;
  public int Hna;
  public long Id;
  public int TEy;
  public LinkedList<ejl> TEz;
  public ejl Unu;
  public String lps;
  public int rWu;
  
  public elh()
  {
    AppMethodBeat.i(125831);
    this.TEz = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.Unu == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Hna);
      paramVarArgs.aY(3, this.HmZ);
      if (this.lps != null) {
        paramVarArgs.f(4, this.lps);
      }
      if (this.Unu != null)
      {
        paramVarArgs.oE(5, this.Unu.computeSize());
        this.Unu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.TEy);
      paramVarArgs.e(7, 8, this.TEz);
      paramVarArgs.bm(8, this.Id);
      paramVarArgs.aY(9, this.rWu);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label928;
      }
    }
    label928:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Hna) + g.a.a.b.b.a.bM(3, this.HmZ);
      paramInt = i;
      if (this.lps != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lps);
      }
      i = paramInt;
      if (this.Unu != null) {
        i = paramInt + g.a.a.a.oD(5, this.Unu.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(6, this.TEy);
      int j = g.a.a.a.c(7, 8, this.TEz);
      int k = g.a.a.b.b.a.p(8, this.Id);
      int m = g.a.a.b.b.a.bM(9, this.rWu);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TEz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.Unu == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elh localelh = (elh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localelh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localelh.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localelh.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localelh.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejl)localObject2).parseFrom((byte[])localObject1);
            }
            localelh.Unu = ((ejl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localelh.TEy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejl)localObject2).parseFrom((byte[])localObject1);
            }
            localelh.TEz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localelh.Id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125832);
          return 0;
        }
        localelh.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elh
 * JD-Core Version:    0.7.0.1
 */