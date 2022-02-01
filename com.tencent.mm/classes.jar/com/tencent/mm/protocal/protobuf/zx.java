package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class zx
  extends dyy
{
  public String Md5;
  public String RVF;
  public int Smj;
  public LinkedList<esd> Smk;
  public int Sml;
  public int rWt;
  
  public zx()
  {
    AppMethodBeat.i(6405);
    this.Smk = new LinkedList();
    AppMethodBeat.o(6405);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6406);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWt);
      if (this.RVF != null) {
        paramVarArgs.f(3, this.RVF);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(4, this.Md5);
      }
      paramVarArgs.aY(5, this.Smj);
      paramVarArgs.e(6, 8, this.Smk);
      paramVarArgs.aY(7, this.Sml);
      AppMethodBeat.o(6406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label731;
      }
    }
    label731:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWt);
      paramInt = i;
      if (this.RVF != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RVF);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Md5);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.Smj);
      int j = g.a.a.a.c(6, 8, this.Smk);
      int k = g.a.a.b.b.a.bM(7, this.Sml);
      AppMethodBeat.o(6406);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Smk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(6406);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6406);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zx localzx = (zx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6406);
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
            localzx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        case 2: 
          localzx.rWt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6406);
          return 0;
        case 3: 
          localzx.RVF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 4: 
          localzx.Md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 5: 
          localzx.Smj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6406);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esd)localObject2).parseFrom((byte[])localObject1);
            }
            localzx.Smk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        }
        localzx.Sml = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6406);
        return 0;
      }
      AppMethodBeat.o(6406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zx
 * JD-Core Version:    0.7.0.1
 */