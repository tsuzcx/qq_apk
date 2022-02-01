package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class efd
  extends dop
{
  public b Buffer;
  public String KSV;
  public int KTf;
  public int KWb;
  public int NeZ;
  public int Nfe;
  public String Nff;
  public ddg Nfg;
  public int Nfh;
  public String Nfi;
  public int Scene;
  public String SessionId;
  public String jfi;
  public LinkedList<efc> xKD;
  
  public efd()
  {
    AppMethodBeat.i(152704);
    this.xKD = new LinkedList();
    AppMethodBeat.o(152704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KSV != null) {
        paramVarArgs.e(2, this.KSV);
      }
      paramVarArgs.aM(3, this.KWb);
      paramVarArgs.e(4, 8, this.xKD);
      paramVarArgs.aM(5, this.Nfe);
      if (this.jfi != null) {
        paramVarArgs.e(6, this.jfi);
      }
      paramVarArgs.aM(7, this.KTf);
      paramVarArgs.aM(8, this.NeZ);
      if (this.Nff != null) {
        paramVarArgs.e(9, this.Nff);
      }
      if (this.Buffer != null) {
        paramVarArgs.c(10, this.Buffer);
      }
      if (this.Nfg != null)
      {
        paramVarArgs.ni(11, this.Nfg.computeSize());
        this.Nfg.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.Scene);
      paramVarArgs.aM(13, this.Nfh);
      if (this.SessionId != null) {
        paramVarArgs.e(14, this.SessionId);
      }
      if (this.Nfi != null) {
        paramVarArgs.e(15, this.Nfi);
      }
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KSV != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KSV);
      }
      i = i + g.a.a.b.b.a.bu(3, this.KWb) + g.a.a.a.c(4, 8, this.xKD) + g.a.a.b.b.a.bu(5, this.Nfe);
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.jfi);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.KTf) + g.a.a.b.b.a.bu(8, this.NeZ);
      paramInt = i;
      if (this.Nff != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Nff);
      }
      i = paramInt;
      if (this.Buffer != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.Buffer);
      }
      paramInt = i;
      if (this.Nfg != null) {
        paramInt = i + g.a.a.a.nh(11, this.Nfg.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.Scene) + g.a.a.b.b.a.bu(13, this.Nfh);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.SessionId);
      }
      i = paramInt;
      if (this.Nfi != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.Nfi);
      }
      AppMethodBeat.o(152705);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xKD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efd localefd = (efd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
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
            localefd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localefd.KSV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localefd.KWb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefd.xKD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localefd.Nfe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localefd.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localefd.KTf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localefd.NeZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localefd.Nff = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localefd.Buffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefd.Nfg = ((ddg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 12: 
          localefd.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152705);
          return 0;
        case 13: 
          localefd.Nfh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152705);
          return 0;
        case 14: 
          localefd.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152705);
          return 0;
        }
        localefd.Nfi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efd
 * JD-Core Version:    0.7.0.1
 */