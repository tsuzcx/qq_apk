package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfh
  extends erp
{
  public String aaLa;
  public LinkedList<String> aaLd;
  public LinkedList<Integer> aaLe;
  
  public dfh()
  {
    AppMethodBeat.i(124524);
    this.aaLd = new LinkedList();
    this.aaLe = new LinkedList();
    AppMethodBeat.o(124524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124525);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaLa != null) {
        paramVarArgs.g(2, this.aaLa);
      }
      paramVarArgs.e(3, 1, this.aaLd);
      paramVarArgs.e(4, 2, this.aaLe);
      AppMethodBeat.o(124525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label467;
      }
    }
    label467:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaLa != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaLa);
      }
      paramInt = i.a.a.a.c(3, 1, this.aaLd);
      int j = i.a.a.a.c(4, 2, this.aaLe);
      AppMethodBeat.o(124525);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaLd.clear();
        this.aaLe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dfh localdfh = (dfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124525);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localdfh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124525);
          return 0;
        case 2: 
          localdfh.aaLa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124525);
          return 0;
        case 3: 
          localdfh.aaLd.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(124525);
          return 0;
        }
        localdfh.aaLe.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
        AppMethodBeat.o(124525);
        return 0;
      }
      AppMethodBeat.o(124525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfh
 * JD-Core Version:    0.7.0.1
 */