package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecb
  extends dop
{
  public com.tencent.mm.bw.b Mpw;
  public String Ncc;
  public String Ncd;
  public String Nce;
  public int Ncf;
  public int Ncg;
  public int Nch;
  public int Nci;
  public ebz Ncj;
  public ebz Nck;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mpw == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.Ncc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.Ncd == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.Nce == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Mpw != null) {
        paramVarArgs.c(2, this.Mpw);
      }
      if (this.Ncc != null) {
        paramVarArgs.e(3, this.Ncc);
      }
      if (this.Ncd != null) {
        paramVarArgs.e(4, this.Ncd);
      }
      if (this.Nce != null) {
        paramVarArgs.e(5, this.Nce);
      }
      paramVarArgs.aM(6, this.Ncf);
      paramVarArgs.aM(7, this.Ncg);
      paramVarArgs.aM(8, this.Nch);
      paramVarArgs.aM(9, this.Nci);
      if (this.Ncj != null)
      {
        paramVarArgs.ni(10, this.Ncj.computeSize());
        this.Ncj.writeFields(paramVarArgs);
      }
      if (this.Nck != null)
      {
        paramVarArgs.ni(11, this.Nck.computeSize());
        this.Nck.writeFields(paramVarArgs);
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
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mpw != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Mpw);
      }
      i = paramInt;
      if (this.Ncc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ncc);
      }
      paramInt = i;
      if (this.Ncd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ncd);
      }
      i = paramInt;
      if (this.Nce != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Nce);
      }
      i = i + g.a.a.b.b.a.bu(6, this.Ncf) + g.a.a.b.b.a.bu(7, this.Ncg) + g.a.a.b.b.a.bu(8, this.Nch) + g.a.a.b.b.a.bu(9, this.Nci);
      paramInt = i;
      if (this.Ncj != null) {
        paramInt = i + g.a.a.a.nh(10, this.Ncj.computeSize());
      }
      i = paramInt;
      if (this.Nck != null) {
        i = paramInt + g.a.a.a.nh(11, this.Nck.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Mpw == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.Ncc == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.Ncd == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.Nce == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecb localecb = (ecb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localecb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localecb.Mpw = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localecb.Ncc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localecb.Ncd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localecb.Nce = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localecb.Ncf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localecb.Ncg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localecb.Nch = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localecb.Nci = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localecb.Ncj = ((ebz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localecb.Nck = ((ebz)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecb
 * JD-Core Version:    0.7.0.1
 */