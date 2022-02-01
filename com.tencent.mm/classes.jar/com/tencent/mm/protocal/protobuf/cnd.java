package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cnd
  extends dyl
{
  public String Tug;
  public String Tuh;
  public String Tui;
  public b Tuj;
  public int Tuk;
  public String Tul;
  public int Tum;
  public LinkedList<cns> Tuq;
  public String appid;
  public String fdH;
  public String signature;
  public String url;
  
  public cnd()
  {
    AppMethodBeat.i(82444);
    this.Tuq = new LinkedList();
    AppMethodBeat.o(82444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      if (this.Tug != null) {
        paramVarArgs.f(4, this.Tug);
      }
      if (this.fdH != null) {
        paramVarArgs.f(5, this.fdH);
      }
      if (this.Tuh != null) {
        paramVarArgs.f(6, this.Tuh);
      }
      if (this.signature != null) {
        paramVarArgs.f(7, this.signature);
      }
      if (this.Tui != null) {
        paramVarArgs.f(8, this.Tui);
      }
      if (this.Tuj != null) {
        paramVarArgs.c(9, this.Tuj);
      }
      paramVarArgs.aY(10, this.Tuk);
      paramVarArgs.e(11, 8, this.Tuq);
      if (this.Tul != null) {
        paramVarArgs.f(12, this.Tul);
      }
      paramVarArgs.aY(13, this.Tum);
      AppMethodBeat.o(82445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appid);
      }
      paramInt = i;
      if (this.Tug != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tug);
      }
      i = paramInt;
      if (this.fdH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fdH);
      }
      paramInt = i;
      if (this.Tuh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tuh);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.signature);
      }
      paramInt = i;
      if (this.Tui != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tui);
      }
      i = paramInt;
      if (this.Tuj != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.Tuj);
      }
      i = i + g.a.a.b.b.a.bM(10, this.Tuk) + g.a.a.a.c(11, 8, this.Tuq);
      paramInt = i;
      if (this.Tul != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Tul);
      }
      i = g.a.a.b.b.a.bM(13, this.Tum);
      AppMethodBeat.o(82445);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tuq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnd localcnd = (cnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82445);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcnd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 2: 
          localcnd.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 3: 
          localcnd.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 4: 
          localcnd.Tug = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 5: 
          localcnd.fdH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 6: 
          localcnd.Tuh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 7: 
          localcnd.signature = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 8: 
          localcnd.Tui = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 9: 
          localcnd.Tuj = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(82445);
          return 0;
        case 10: 
          localcnd.Tuk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(82445);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cns();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cns)localObject2).parseFrom((byte[])localObject1);
            }
            localcnd.Tuq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 12: 
          localcnd.Tul = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82445);
          return 0;
        }
        localcnd.Tum = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(82445);
        return 0;
      }
      AppMethodBeat.o(82445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnd
 * JD-Core Version:    0.7.0.1
 */