package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czf
  extends dpc
{
  public LinkedList<sa> MEu;
  public String MEv;
  public String MEw;
  public String MEx;
  public efl MEy;
  public String MEz;
  public String Mbb;
  public efl MlS;
  
  public czf()
  {
    AppMethodBeat.i(117890);
    this.MEu = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mbb != null) {
        paramVarArgs.e(2, this.Mbb);
      }
      if (this.MlS != null)
      {
        paramVarArgs.ni(3, this.MlS.computeSize());
        this.MlS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.MEu);
      if (this.MEv != null) {
        paramVarArgs.e(5, this.MEv);
      }
      if (this.MEw != null) {
        paramVarArgs.e(6, this.MEw);
      }
      if (this.MEx != null) {
        paramVarArgs.e(7, this.MEx);
      }
      if (this.MEy != null)
      {
        paramVarArgs.ni(8, this.MEy.computeSize());
        this.MEy.writeFields(paramVarArgs);
      }
      if (this.MEz != null) {
        paramVarArgs.e(9, this.MEz);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mbb);
      }
      i = paramInt;
      if (this.MlS != null) {
        i = paramInt + g.a.a.a.nh(3, this.MlS.computeSize());
      }
      i += g.a.a.a.c(4, 8, this.MEu);
      paramInt = i;
      if (this.MEv != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MEv);
      }
      i = paramInt;
      if (this.MEw != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MEw);
      }
      paramInt = i;
      if (this.MEx != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MEx);
      }
      i = paramInt;
      if (this.MEy != null) {
        i = paramInt + g.a.a.a.nh(8, this.MEy.computeSize());
      }
      paramInt = i;
      if (this.MEz != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MEz);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MEu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        czf localczf = (czf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localczf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localczf.Mbb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localczf.MlS = ((efl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localczf.MEu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localczf.MEv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localczf.MEw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localczf.MEx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localczf.MEy = ((efl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localczf.MEz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czf
 * JD-Core Version:    0.7.0.1
 */