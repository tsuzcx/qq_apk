package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class abx
  extends esc
{
  public String Md5;
  public String YTj;
  public int Zkv;
  public LinkedList<fnm> Zkw;
  public int Zkx;
  public int crz;
  
  public abx()
  {
    AppMethodBeat.i(6405);
    this.Zkw = new LinkedList();
    AppMethodBeat.o(6405);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6406);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6406);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.crz);
      if (this.YTj != null) {
        paramVarArgs.g(3, this.YTj);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(4, this.Md5);
      }
      paramVarArgs.bS(5, this.Zkv);
      paramVarArgs.e(6, 8, this.Zkw);
      paramVarArgs.bS(7, this.Zkx);
      AppMethodBeat.o(6406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label727;
      }
    }
    label727:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.crz);
      paramInt = i;
      if (this.YTj != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YTj);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Md5);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.Zkv);
      int j = i.a.a.a.c(6, 8, this.Zkw);
      int k = i.a.a.b.b.a.cJ(7, this.Zkx);
      AppMethodBeat.o(6406);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zkw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        abx localabx = (abx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6406);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localabx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        case 2: 
          localabx.crz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6406);
          return 0;
        case 3: 
          localabx.YTj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 4: 
          localabx.Md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 5: 
          localabx.Zkv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6406);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnm)localObject2).parseFrom((byte[])localObject1);
            }
            localabx.Zkw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        }
        localabx.Zkx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(6406);
        return 0;
      }
      AppMethodBeat.o(6406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abx
 * JD-Core Version:    0.7.0.1
 */