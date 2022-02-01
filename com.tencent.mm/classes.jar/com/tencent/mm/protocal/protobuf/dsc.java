package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsc
  extends esc
{
  public String EdM;
  public String Meg;
  public String Meh;
  public String aaXV;
  public long aaXX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259885);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaXX);
      if (this.EdM != null) {
        paramVarArgs.g(3, this.EdM);
      }
      if (this.aaXV != null) {
        paramVarArgs.g(4, this.aaXV);
      }
      if (this.Meg != null) {
        paramVarArgs.g(5, this.Meg);
      }
      if (this.Meh != null) {
        paramVarArgs.g(6, this.Meh);
      }
      AppMethodBeat.o(259885);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaXX);
      paramInt = i;
      if (this.EdM != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.EdM);
      }
      i = paramInt;
      if (this.aaXV != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaXV);
      }
      paramInt = i;
      if (this.Meg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Meg);
      }
      i = paramInt;
      if (this.Meh != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Meh);
      }
      AppMethodBeat.o(259885);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259885);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dsc localdsc = (dsc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259885);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localdsc.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259885);
          return 0;
        case 2: 
          localdsc.aaXX = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259885);
          return 0;
        case 3: 
          localdsc.EdM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259885);
          return 0;
        case 4: 
          localdsc.aaXV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259885);
          return 0;
        case 5: 
          localdsc.Meg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259885);
          return 0;
        }
        localdsc.Meh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259885);
        return 0;
      }
      AppMethodBeat.o(259885);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsc
 * JD-Core Version:    0.7.0.1
 */