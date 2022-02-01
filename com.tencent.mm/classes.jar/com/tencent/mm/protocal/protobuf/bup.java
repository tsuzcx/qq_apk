package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bup
  extends erp
{
  public atz YIY;
  public String aaaG;
  public String aabM;
  public b aacl;
  public String query;
  public String request_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259243);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.aacl != null) {
        paramVarArgs.d(3, this.aacl);
      }
      if (this.query != null) {
        paramVarArgs.g(4, this.query);
      }
      if (this.request_id != null) {
        paramVarArgs.g(5, this.request_id);
      }
      if (this.aabM != null) {
        paramVarArgs.g(6, this.aabM);
      }
      if (this.aaaG != null) {
        paramVarArgs.g(7, this.aaaG);
      }
      AppMethodBeat.o(259243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.aacl != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aacl);
      }
      paramInt = i;
      if (this.query != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.query);
      }
      i = paramInt;
      if (this.request_id != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.request_id);
      }
      paramInt = i;
      if (this.aabM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aabM);
      }
      i = paramInt;
      if (this.aaaG != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaaG);
      }
      AppMethodBeat.o(259243);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bup localbup = (bup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259243);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbup.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259243);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbup.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259243);
          return 0;
        case 3: 
          localbup.aacl = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259243);
          return 0;
        case 4: 
          localbup.query = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259243);
          return 0;
        case 5: 
          localbup.request_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259243);
          return 0;
        case 6: 
          localbup.aabM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259243);
          return 0;
        }
        localbup.aaaG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259243);
        return 0;
      }
      AppMethodBeat.o(259243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bup
 * JD-Core Version:    0.7.0.1
 */