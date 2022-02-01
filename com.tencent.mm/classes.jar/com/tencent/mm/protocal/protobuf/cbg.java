package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbg
  extends erp
{
  public String IJD;
  public LinkedList<String> aakq;
  public LinkedList<String> aakw;
  public int aakx;
  public String pSo;
  
  public cbg()
  {
    AppMethodBeat.i(42638);
    this.aakw = new LinkedList();
    this.aakq = new LinkedList();
    AppMethodBeat.o(42638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42639);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.aakw);
      paramVarArgs.e(3, 1, this.aakq);
      if (this.IJD != null) {
        paramVarArgs.g(4, this.IJD);
      }
      if (this.pSo != null) {
        paramVarArgs.g(5, this.pSo);
      }
      paramVarArgs.bS(6, this.aakx);
      AppMethodBeat.o(42639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.aakw) + i.a.a.a.c(3, 1, this.aakq);
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IJD);
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSo);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.aakx);
      AppMethodBeat.o(42639);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aakw.clear();
        this.aakq.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(42639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cbg localcbg = (cbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42639);
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
            localcbg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(42639);
          return 0;
        case 2: 
          localcbg.aakw.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 3: 
          localcbg.aakq.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 4: 
          localcbg.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42639);
          return 0;
        case 5: 
          localcbg.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42639);
          return 0;
        }
        localcbg.aakx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(42639);
        return 0;
      }
      AppMethodBeat.o(42639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbg
 * JD-Core Version:    0.7.0.1
 */