package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dir
  extends cvw
{
  public String HQk;
  public String HQl;
  public String HQm;
  public int HQn;
  public int HQo;
  public int HQp;
  public int HQq;
  public dip HQr;
  public dip HQs;
  public com.tencent.mm.bw.b Hjt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hjt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.HQk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.HQl == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.HQm == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hjt != null) {
        paramVarArgs.c(2, this.Hjt);
      }
      if (this.HQk != null) {
        paramVarArgs.d(3, this.HQk);
      }
      if (this.HQl != null) {
        paramVarArgs.d(4, this.HQl);
      }
      if (this.HQm != null) {
        paramVarArgs.d(5, this.HQm);
      }
      paramVarArgs.aS(6, this.HQn);
      paramVarArgs.aS(7, this.HQo);
      paramVarArgs.aS(8, this.HQp);
      paramVarArgs.aS(9, this.HQq);
      if (this.HQr != null)
      {
        paramVarArgs.lJ(10, this.HQr.computeSize());
        this.HQr.writeFields(paramVarArgs);
      }
      if (this.HQs != null)
      {
        paramVarArgs.lJ(11, this.HQs.computeSize());
        this.HQs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hjt != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Hjt);
      }
      i = paramInt;
      if (this.HQk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HQk);
      }
      paramInt = i;
      if (this.HQl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HQl);
      }
      i = paramInt;
      if (this.HQm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HQm);
      }
      i = i + f.a.a.b.b.a.bz(6, this.HQn) + f.a.a.b.b.a.bz(7, this.HQo) + f.a.a.b.b.a.bz(8, this.HQp) + f.a.a.b.b.a.bz(9, this.HQq);
      paramInt = i;
      if (this.HQr != null) {
        paramInt = i + f.a.a.a.lI(10, this.HQr.computeSize());
      }
      i = paramInt;
      if (this.HQs != null) {
        i = paramInt + f.a.a.a.lI(11, this.HQs.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Hjt == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.HQk == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.HQl == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.HQm == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dir localdir = (dir)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdir.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localdir.Hjt = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localdir.HQk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localdir.HQl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localdir.HQm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localdir.HQn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localdir.HQo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localdir.HQp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localdir.HQq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdir.HQr = ((dip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dip();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdir.HQs = ((dip)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      AppMethodBeat.o(133198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dir
 * JD-Core Version:    0.7.0.1
 */