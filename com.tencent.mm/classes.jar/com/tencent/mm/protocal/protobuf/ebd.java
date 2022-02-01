package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ebd
  extends dyl
{
  public int SrG;
  public int TKW;
  public LinkedList<String> TKX;
  public String UfZ;
  public String Uga;
  public b Ugb;
  public b Ugc;
  public String appid;
  public String state;
  
  public ebd()
  {
    AppMethodBeat.i(82470);
    this.TKX = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.TKW);
      paramVarArgs.e(4, 1, this.TKX);
      if (this.appid != null) {
        paramVarArgs.f(5, this.appid);
      }
      if (this.state != null) {
        paramVarArgs.f(6, this.state);
      }
      if (this.UfZ != null) {
        paramVarArgs.f(7, this.UfZ);
      }
      paramVarArgs.aY(8, this.SrG);
      if (this.Uga != null) {
        paramVarArgs.f(14, this.Uga);
      }
      if (this.Ugb != null) {
        paramVarArgs.c(15, this.Ugb);
      }
      if (this.Ugc != null) {
        paramVarArgs.c(16, this.Ugc);
      }
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(3, this.TKW) + g.a.a.a.c(4, 1, this.TKX);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.appid);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.state);
      }
      paramInt = i;
      if (this.UfZ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UfZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.SrG);
      paramInt = i;
      if (this.Uga != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Uga);
      }
      i = paramInt;
      if (this.Ugb != null) {
        i = paramInt + g.a.a.b.b.a.b(15, this.Ugb);
      }
      paramInt = i;
      if (this.Ugc != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.Ugc);
      }
      AppMethodBeat.o(82471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TKX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ebd localebd = (ebd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(82471);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localebd.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localebd.TKW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localebd.TKX.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localebd.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localebd.state = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localebd.UfZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localebd.SrG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82471);
          return 0;
        case 14: 
          localebd.Uga = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 15: 
          localebd.Ugb = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(82471);
          return 0;
        }
        localebd.Ugc = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebd
 * JD-Core Version:    0.7.0.1
 */