package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aek
  extends com.tencent.mm.bx.a
{
  public String YIZ;
  public String Zdw;
  public String Zdx;
  public long ZeU;
  public String ZeV;
  public String ZeW;
  public String ZeX;
  public cxm Zmn;
  public String Zmo;
  public String Zmp;
  public String Zmq;
  public String Zmr;
  public String icon_url;
  public String mdD;
  public String title;
  public String url;
  public String wsA;
  public String wsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(2, this.wsz);
      }
      if (this.wsA != null) {
        paramVarArgs.g(3, this.wsA);
      }
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      paramVarArgs.bv(5, this.ZeU);
      if (this.ZeV != null) {
        paramVarArgs.g(6, this.ZeV);
      }
      if (this.ZeW != null) {
        paramVarArgs.g(7, this.ZeW);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(8, this.icon_url);
      }
      if (this.Zmn != null)
      {
        paramVarArgs.qD(9, this.Zmn.computeSize());
        this.Zmn.writeFields(paramVarArgs);
      }
      if (this.Zdw != null) {
        paramVarArgs.g(10, this.Zdw);
      }
      if (this.Zdx != null) {
        paramVarArgs.g(11, this.Zdx);
      }
      if (this.Zmo != null) {
        paramVarArgs.g(13, this.Zmo);
      }
      if (this.Zmp != null) {
        paramVarArgs.g(14, this.Zmp);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(15, this.YIZ);
      }
      if (this.Zmq != null) {
        paramVarArgs.g(16, this.Zmq);
      }
      if (this.Zmr != null) {
        paramVarArgs.g(17, this.Zmr);
      }
      if (this.ZeX != null) {
        paramVarArgs.g(18, this.ZeX);
      }
      if (this.mdD != null) {
        paramVarArgs.g(19, this.mdD);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1320;
      }
    }
    label1320:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wsz);
      }
      i = paramInt;
      if (this.wsA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wsA);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.ZeU);
      paramInt = i;
      if (this.ZeV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZeV);
      }
      i = paramInt;
      if (this.ZeW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZeW);
      }
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.icon_url);
      }
      i = paramInt;
      if (this.Zmn != null) {
        i = paramInt + i.a.a.a.qC(9, this.Zmn.computeSize());
      }
      paramInt = i;
      if (this.Zdw != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Zdw);
      }
      i = paramInt;
      if (this.Zdx != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Zdx);
      }
      paramInt = i;
      if (this.Zmo != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Zmo);
      }
      i = paramInt;
      if (this.Zmp != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.Zmp);
      }
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YIZ);
      }
      i = paramInt;
      if (this.Zmq != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.Zmq);
      }
      paramInt = i;
      if (this.Zmr != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Zmr);
      }
      i = paramInt;
      if (this.ZeX != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.ZeX);
      }
      paramInt = i;
      if (this.mdD != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.mdD);
      }
      AppMethodBeat.o(113985);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aek localaek = (aek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localaek.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localaek.wsz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localaek.wsA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localaek.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localaek.ZeU = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localaek.ZeV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localaek.ZeW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localaek.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cxm localcxm = new cxm();
            if ((localObject != null) && (localObject.length > 0)) {
              localcxm.parseFrom((byte[])localObject);
            }
            localaek.Zmn = localcxm;
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localaek.Zdw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 11: 
          localaek.Zdx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 13: 
          localaek.Zmo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 14: 
          localaek.Zmp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 15: 
          localaek.YIZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 16: 
          localaek.Zmq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 17: 
          localaek.Zmr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 18: 
          localaek.ZeX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localaek.mdD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aek
 * JD-Core Version:    0.7.0.1
 */