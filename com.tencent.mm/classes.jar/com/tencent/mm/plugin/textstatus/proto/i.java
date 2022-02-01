package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class i
  extends erp
{
  public String ToJ;
  public String ToK;
  public LinkedList<String> ToM;
  
  public i()
  {
    AppMethodBeat.i(290034);
    this.ToM = new LinkedList();
    AppMethodBeat.o(290034);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290044);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ToJ != null) {
        paramVarArgs.g(2, this.ToJ);
      }
      paramVarArgs.e(3, 1, this.ToM);
      if (this.ToK != null) {
        paramVarArgs.g(4, this.ToK);
      }
      AppMethodBeat.o(290044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ToJ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ToJ);
      }
      i += i.a.a.a.c(3, 1, this.ToM);
      paramInt = i;
      if (this.ToK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ToK);
      }
      AppMethodBeat.o(290044);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ToM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290044);
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
            locali.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(290044);
          return 0;
        case 2: 
          locali.ToJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290044);
          return 0;
        case 3: 
          locali.ToM.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(290044);
          return 0;
        }
        locali.ToK = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(290044);
        return 0;
      }
      AppMethodBeat.o(290044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.i
 * JD-Core Version:    0.7.0.1
 */