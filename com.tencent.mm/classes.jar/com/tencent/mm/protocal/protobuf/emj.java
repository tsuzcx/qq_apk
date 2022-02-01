package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emj
  extends erp
{
  public String OzQ;
  public int aaLf;
  public String mut;
  public String muu;
  public String muv;
  public String muw;
  public String mux;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mut != null) {
        paramVarArgs.g(2, this.mut);
      }
      if (this.muu != null) {
        paramVarArgs.g(3, this.muu);
      }
      if (this.muv != null) {
        paramVarArgs.g(4, this.muv);
      }
      if (this.muw != null) {
        paramVarArgs.g(5, this.muw);
      }
      if (this.mux != null) {
        paramVarArgs.g(6, this.mux);
      }
      paramVarArgs.bS(7, this.aaLf);
      if (this.OzQ != null) {
        paramVarArgs.g(8, this.OzQ);
      }
      AppMethodBeat.o(152666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label696;
      }
    }
    label696:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mut);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.muu);
      }
      paramInt = i;
      if (this.muv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.muv);
      }
      i = paramInt;
      if (this.muw != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.muw);
      }
      paramInt = i;
      if (this.mux != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mux);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.aaLf);
      paramInt = i;
      if (this.OzQ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.OzQ);
      }
      AppMethodBeat.o(152666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        emj localemj = (emj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152666);
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
            localemj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152666);
          return 0;
        case 2: 
          localemj.mut = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 3: 
          localemj.muu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 4: 
          localemj.muv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 5: 
          localemj.muw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 6: 
          localemj.mux = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 7: 
          localemj.aaLf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152666);
          return 0;
        }
        localemj.OzQ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152666);
        return 0;
      }
      AppMethodBeat.o(152666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emj
 * JD-Core Version:    0.7.0.1
 */