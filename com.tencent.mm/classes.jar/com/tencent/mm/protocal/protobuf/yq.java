package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yq
  extends erp
{
  public LinkedList<Integer> ZgH;
  public boolean Zhl;
  public boolean Zhm;
  public String desc;
  
  public yq()
  {
    AppMethodBeat.i(72444);
    this.ZgH = new LinkedList();
    AppMethodBeat.o(72444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.ZgH);
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      paramVarArgs.di(4, this.Zhl);
      paramVarArgs.di(5, this.Zhm);
      AppMethodBeat.o(72445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label495;
      }
    }
    label495:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 2, this.ZgH);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.desc);
      }
      i = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(72445);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZgH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yq localyq = (yq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72445);
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
            localyq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72445);
          return 0;
        case 2: 
          localyq.ZgH.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(72445);
          return 0;
        case 3: 
          localyq.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72445);
          return 0;
        case 4: 
          localyq.Zhl = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(72445);
          return 0;
        }
        localyq.Zhm = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(72445);
        return 0;
      }
      AppMethodBeat.o(72445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yq
 * JD-Core Version:    0.7.0.1
 */