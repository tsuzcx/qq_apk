package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cmb
  extends esc
{
  public int YYp;
  public String YYr;
  public gol aatT;
  public int aatY;
  public LinkedList<etl> aatZ;
  public int aaua;
  public LinkedList<dgz> aaub;
  public String aauc;
  public int aaud;
  public int aaue;
  public dha aauf;
  public String aaug;
  public String pSh;
  
  public cmb()
  {
    AppMethodBeat.i(32251);
    this.aatZ = new LinkedList();
    this.aaub = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.aatT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aatT != null)
      {
        paramVarArgs.qD(2, this.aatT.computeSize());
        this.aatT.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aatY);
      paramVarArgs.e(4, 8, this.aatZ);
      paramVarArgs.bS(5, this.aaua);
      paramVarArgs.e(6, 8, this.aaub);
      paramVarArgs.bS(7, this.YYp);
      if (this.aauc != null) {
        paramVarArgs.g(8, this.aauc);
      }
      if (this.YYr != null) {
        paramVarArgs.g(9, this.YYr);
      }
      paramVarArgs.bS(10, this.aaud);
      if (this.pSh != null) {
        paramVarArgs.g(11, this.pSh);
      }
      paramVarArgs.bS(12, this.aaue);
      if (this.aauf != null)
      {
        paramVarArgs.qD(13, this.aauf.computeSize());
        this.aauf.writeFields(paramVarArgs);
      }
      if (this.aaug != null) {
        paramVarArgs.g(14, this.aaug);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1376;
      }
    }
    label1376:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aatT != null) {
        i = paramInt + i.a.a.a.qC(2, this.aatT.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aatY) + i.a.a.a.c(4, 8, this.aatZ) + i.a.a.b.b.a.cJ(5, this.aaua) + i.a.a.a.c(6, 8, this.aaub) + i.a.a.b.b.a.cJ(7, this.YYp);
      paramInt = i;
      if (this.aauc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aauc);
      }
      i = paramInt;
      if (this.YYr != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YYr);
      }
      i += i.a.a.b.b.a.cJ(10, this.aaud);
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.pSh);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.aaue);
      paramInt = i;
      if (this.aauf != null) {
        paramInt = i + i.a.a.a.qC(13, this.aauf.computeSize());
      }
      i = paramInt;
      if (this.aaug != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.aaug);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aatZ.clear();
        this.aaub.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.aatT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cmb localcmb = (cmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcmb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcmb.aatT = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localcmb.aatY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcmb.aatZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localcmb.aaua = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgz)localObject2).parseFrom((byte[])localObject1);
            }
            localcmb.aaub.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localcmb.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localcmb.aauc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localcmb.YYr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localcmb.aaud = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localcmb.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localcmb.aaue = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dha)localObject2).parseFrom((byte[])localObject1);
            }
            localcmb.aauf = ((dha)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localcmb.aaug = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmb
 * JD-Core Version:    0.7.0.1
 */