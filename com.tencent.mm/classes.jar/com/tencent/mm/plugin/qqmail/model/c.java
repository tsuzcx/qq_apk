package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class c
  extends erp
{
  public int Njm;
  public String Njn;
  public String Njo;
  public String Njp;
  public String Njq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267025);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Njm);
      if (this.Njn != null) {
        paramVarArgs.g(3, this.Njn);
      }
      if (this.Njo != null) {
        paramVarArgs.g(4, this.Njo);
      }
      if (this.Njp != null) {
        paramVarArgs.g(5, this.Njp);
      }
      if (this.Njq != null) {
        paramVarArgs.g(6, this.Njq);
      }
      AppMethodBeat.o(267025);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Njm);
      paramInt = i;
      if (this.Njn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Njn);
      }
      i = paramInt;
      if (this.Njo != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Njo);
      }
      paramInt = i;
      if (this.Njp != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Njp);
      }
      i = paramInt;
      if (this.Njq != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Njq);
      }
      AppMethodBeat.o(267025);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267025);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267025);
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
            localc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(267025);
          return 0;
        case 2: 
          localc.Njm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(267025);
          return 0;
        case 3: 
          localc.Njn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267025);
          return 0;
        case 4: 
          localc.Njo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267025);
          return 0;
        case 5: 
          localc.Njp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267025);
          return 0;
        }
        localc.Njq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(267025);
        return 0;
      }
      AppMethodBeat.o(267025);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.c
 * JD-Core Version:    0.7.0.1
 */