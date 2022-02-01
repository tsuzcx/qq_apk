package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddc
  extends dyl
{
  public int SrG;
  public String TKV;
  public int TKW;
  public LinkedList<String> TKX;
  
  public ddc()
  {
    AppMethodBeat.i(82457);
    this.TKX = new LinkedList();
    AppMethodBeat.o(82457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TKV != null) {
        paramVarArgs.f(2, this.TKV);
      }
      paramVarArgs.aY(3, this.TKW);
      paramVarArgs.e(4, 1, this.TKX);
      paramVarArgs.aY(5, this.SrG);
      AppMethodBeat.o(82458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TKV != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TKV);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TKW);
      int j = g.a.a.a.c(4, 1, this.TKX);
      int k = g.a.a.b.b.a.bM(5, this.SrG);
      AppMethodBeat.o(82458);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TKX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ddc localddc = (ddc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82458);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localddc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82458);
          return 0;
        case 2: 
          localddc.TKV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82458);
          return 0;
        case 3: 
          localddc.TKW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82458);
          return 0;
        case 4: 
          localddc.TKX.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(82458);
          return 0;
        }
        localddc.SrG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(82458);
        return 0;
      }
      AppMethodBeat.o(82458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddc
 * JD-Core Version:    0.7.0.1
 */