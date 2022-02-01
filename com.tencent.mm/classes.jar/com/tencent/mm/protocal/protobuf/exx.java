package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exx
  extends dop
{
  public LinkedList<Integer> Nvf;
  public String dNI;
  public int id;
  public String query;
  
  public exx()
  {
    AppMethodBeat.i(121118);
    this.Nvf = new LinkedList();
    AppMethodBeat.o(121118);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.aM(3, this.id);
      paramVarArgs.e(4, 2, this.Nvf);
      if (this.query != null) {
        paramVarArgs.e(5, this.query);
      }
      AppMethodBeat.o(121119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = i + g.a.a.b.b.a.bu(3, this.id) + g.a.a.a.c(4, 2, this.Nvf);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.query);
      }
      AppMethodBeat.o(121119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nvf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(121119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exx localexx = (exx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121119);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localexx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121119);
          return 0;
        case 2: 
          localexx.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(121119);
          return 0;
        case 3: 
          localexx.id = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(121119);
          return 0;
        case 4: 
          localexx.Nvf.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(121119);
          return 0;
        }
        localexx.query = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(121119);
        return 0;
      }
      AppMethodBeat.o(121119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exx
 * JD-Core Version:    0.7.0.1
 */